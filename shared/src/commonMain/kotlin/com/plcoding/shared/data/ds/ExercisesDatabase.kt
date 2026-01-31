package com.plcoding.shared.data.ds

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.plcoding.shared.data.model.Exercise
import com.plcoding.shared.data.model.TrainingDay

@Database(version = 1, entities = [TrainingDay::class, Exercise::class])
@ConstructedBy(ExerciseDatabaseConstructor::class)
abstract class ExercisesDatabase : RoomDatabase() {
    abstract fun exercisesDao(): ExercisesDao
}

/** The Room compiler generates the `actual` implementations. */
@Suppress("KotlinNoActualForExpect")
expect object ExerciseDatabaseConstructor : RoomDatabaseConstructor<ExercisesDatabase> {
    override fun initialize(): ExercisesDatabase
}
