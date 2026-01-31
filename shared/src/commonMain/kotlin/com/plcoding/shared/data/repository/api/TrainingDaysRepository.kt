package com.plcoding.shared.data.repository.api

import com.plcoding.shared.presentation.model.Exercise
import com.plcoding.shared.presentation.model.TrainingDay
import kotlinx.coroutines.flow.Flow

interface TrainingDaysRepository {
    suspend fun getTrainingDays(): Flow<List<TrainingDay>>
    suspend fun getExercises(day: Int): Flow<List<Exercise>>
}
