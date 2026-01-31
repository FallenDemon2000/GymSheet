package com.plcoding.shared.data.ds

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.plcoding.shared.data.model.Exercise
import com.plcoding.shared.data.model.TrainingDay
import com.plcoding.shared.data.model.TrainingDaysAndExercise
import kotlinx.coroutines.flow.Flow

@Dao
interface ExercisesDao {
    @Transaction
    @Query("SELECT * FROM trainingDay ORDER BY day ASC")
    fun getTrainingDays(): Flow<List<TrainingDaysAndExercise>>

    @Transaction
    @Query("SELECT * FROM exercise WHERE day = :day")
    fun getExercisesByDay(day: Int): Flow<List<Exercise>>

    @Insert
    suspend fun insertDays(vararg trainingDay: TrainingDay)

    @Insert
    suspend fun insertExercises(vararg exercise: Exercise)
}
