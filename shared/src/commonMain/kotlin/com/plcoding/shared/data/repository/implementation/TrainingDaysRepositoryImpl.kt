package com.plcoding.shared.data.repository.implementation

import com.plcoding.shared.data.ds.ExercisesDao
import com.plcoding.shared.data.ktx.mapToEntity
import com.plcoding.shared.data.ktx.mapToExercise
import com.plcoding.shared.data.ktx.mapToTrainingDay
import com.plcoding.shared.data.repository.api.TrainingDaysRepository
import com.plcoding.shared.presentation.model.Exercise
import com.plcoding.shared.presentation.model.TrainingDay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TrainingDaysRepositoryImpl(
    val exercisesDao: ExercisesDao,
) : TrainingDaysRepository {

    override suspend fun getTrainingDays(): Flow<List<TrainingDay>> =
        exercisesDao.getTrainingDays().map { it.mapToTrainingDay() }

    override suspend fun getExercises(day: Int): Flow<List<Exercise>> =
        exercisesDao.getExercisesByDay(day).map { it.mapToExercise() }

    override suspend fun updateExercise(exercise: Exercise) =
        exercisesDao.updateExercise(exercise.mapToEntity())
}
