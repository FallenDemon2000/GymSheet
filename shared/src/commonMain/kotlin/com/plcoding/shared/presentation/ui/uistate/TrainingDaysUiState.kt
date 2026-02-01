package com.plcoding.shared.presentation.ui.uistate

import com.plcoding.shared.presentation.model.TrainingDay

sealed interface TrainingDaysUiState {
    object Loading: TrainingDaysUiState
    data class Success(val trainingDays: List<TrainingDay>): TrainingDaysUiState
    data class Error(val message: String): TrainingDaysUiState
}
