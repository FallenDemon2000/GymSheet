package com.plcoding.shared.data.repository.implementation

import com.plcoding.shared.data.ds.api.TrainingDaysDataSource
import com.plcoding.shared.data.repository.api.TrainingDaysRepository
import com.plcoding.shared.presentation.model.Exercise
import com.plcoding.shared.presentation.model.TrainingDay

class TrainingDaysRepositoryImpl(
    val dataSource: TrainingDaysDataSource,
) : TrainingDaysRepository {

    override suspend fun getTrainingDays(): List<TrainingDay> =
        dataSource.getTrainingDays()

    override suspend fun getExercises(day: Int): List<Exercise>? =
        dataSource.getExercises(day)
}
