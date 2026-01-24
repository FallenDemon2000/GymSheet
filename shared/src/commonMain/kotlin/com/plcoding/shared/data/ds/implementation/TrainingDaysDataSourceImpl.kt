package com.plcoding.shared.data.ds.implementation

import com.plcoding.shared.data.ds.api.TrainingDaysDataSource
import com.plcoding.shared.presentation.icons.BackDayIcon
import com.plcoding.shared.presentation.icons.ChestDayIcon
import com.plcoding.shared.presentation.icons.LegDayIcon
import com.plcoding.shared.presentation.model.TrainingDay
import kotlinx.coroutines.delay

class TrainingDaysDataSourceImpl: TrainingDaysDataSource {
    override suspend fun getTrainingDays(): List<TrainingDay> {
        delay(2000L)
        return staticTrainingDays
    }
}

private val staticTrainingDays = listOf(
    TrainingDay(
        day = 1,
        description = "Back and Biceps training",
        icon = BackDayIcon,
        contentDescription = "Back Day Icon"
    ),
    TrainingDay(
        day = 2,
        description = "Chest and Triceps training",
        icon = ChestDayIcon,
        contentDescription = "Chest Day Icon",
    ),
    TrainingDay(
        day = 3,
        description = "Legs training",
        icon = LegDayIcon,
        contentDescription = "Legs Day Icon",
    ),
)
