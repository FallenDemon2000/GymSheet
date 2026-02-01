package com.plcoding.shared.data.ds

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.plcoding.shared.data.model.ExerciseEntity
import com.plcoding.shared.data.model.TrainingDayEntity

@Database(version = 1, entities = [TrainingDayEntity::class, ExerciseEntity::class])
@ConstructedBy(ExerciseDatabaseConstructor::class)
abstract class ExercisesDatabase : RoomDatabase() {
    abstract fun exercisesDao(): ExercisesDao
}

/** The Room compiler generates the `actual` implementations. */
@Suppress("KotlinNoActualForExpect")
expect object ExerciseDatabaseConstructor : RoomDatabaseConstructor<ExercisesDatabase> {
    override fun initialize(): ExercisesDatabase
}
