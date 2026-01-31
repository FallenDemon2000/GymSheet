package com.plcoding.shared.presentation.ui.uistate

import com.plcoding.shared.data.model.Exercise

sealed interface ExercisesUiState {
    object Loading: ExercisesUiState
    data class Success(val exercises: List<Exercise>): ExercisesUiState
    data class Error(val message: String): ExercisesUiState
}
