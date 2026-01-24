package com.plcoding.shared.data.repository.api

import com.plcoding.shared.presentation.model.TrainingDay

interface TrainingDaysRepository {
    suspend fun getTrainingDays(): List<TrainingDay>
}
