package com.plcoding.shared.ktx

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.plcoding.shared.data.ds.ExercisesDatabase
import java.text.DecimalFormat

actual fun formatNumber(value: Float): String =
    DecimalFormat("#.##").format(value)

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<ExercisesDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("exercises.db")
    return Room.databaseBuilder<ExercisesDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}
