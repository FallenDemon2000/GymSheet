package com.plcoding.shared.data.repository.implementation

import com.plcoding.shared.data.ds.ExercisesDao
import com.plcoding.shared.data.model.Exercise
import com.plcoding.shared.data.model.TrainingDay
import com.plcoding.shared.data.repository.api.TrainingDaysRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TrainingDaysRepositoryImpl(
    val exercisesDao: ExercisesDao,
) : TrainingDaysRepository {

    override suspend fun getTrainingDays(): Flow<List<TrainingDay>> =
        exercisesDao.getTrainingDays().map { list -> list.map { it.trainingDay } }

    override suspend fun getExercises(day: Int): Flow<List<Exercise>> =
        exercisesDao.getExercisesByDay(day)
}
