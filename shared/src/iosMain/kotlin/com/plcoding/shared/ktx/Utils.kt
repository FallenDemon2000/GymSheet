package com.plcoding.shared.ktx

import androidx.room.Room
import androidx.room.RoomDatabase
import com.plcoding.shared.data.ds.ExercisesDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSNumber
import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSUserDomainMask
import platform.Foundation.numberWithFloat

actual fun formatNumber(value: Float): String {
    val formatter = NSNumberFormatter().apply {
        minimumFractionDigits = 0u
        maximumFractionDigits = 2u
        decimalSeparator = "."
    }
    return formatter.stringFromNumber(NSNumber.numberWithFloat(value)) ?: value.toString()
}

fun getDatabaseBuilder(): RoomDatabase.Builder<ExercisesDatabase> {
    val dbFilePath = documentDirectory() + "/exercises.db"
    return Room.databaseBuilder<ExercisesDatabase>(
        name = dbFilePath,
    )
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}
