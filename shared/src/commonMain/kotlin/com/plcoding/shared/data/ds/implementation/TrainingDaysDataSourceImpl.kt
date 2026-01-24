package com.plcoding.shared.data.ds.implementation

import com.plcoding.shared.data.ds.StaticData
import com.plcoding.shared.data.ds.api.TrainingDaysDataSource
import com.plcoding.shared.presentation.model.TrainingDay
import kotlinx.coroutines.delay

class TrainingDaysDataSourceImpl: TrainingDaysDataSource {
    override suspend fun getTrainingDays(): List<TrainingDay> {
        delay(2000L)
        return StaticData.staticTrainingDays
    }
}
