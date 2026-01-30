package com.plcoding.shared.data.repository.api

import com.plcoding.shared.data.model.Exercise
import com.plcoding.shared.data.model.TrainingDay

interface TrainingDaysRepository {
    suspend fun getTrainingDays(): List<TrainingDay>
    suspend fun getExercises(day: Int): List<Exercise>?
}
