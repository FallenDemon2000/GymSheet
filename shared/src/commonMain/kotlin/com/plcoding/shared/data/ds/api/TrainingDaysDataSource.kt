package com.plcoding.shared.data.ds.api

import com.plcoding.shared.data.model.Exercise
import com.plcoding.shared.data.model.TrainingDay

interface TrainingDaysDataSource {
    suspend fun getTrainingDays(): List<TrainingDay>
    suspend fun getExercises(day: Int): List<Exercise>?
}
