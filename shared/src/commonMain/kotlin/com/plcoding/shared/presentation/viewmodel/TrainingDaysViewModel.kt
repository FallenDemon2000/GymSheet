package com.plcoding.shared.presentation.viewmodel

import com.plcoding.shared.BaseViewModel
import com.plcoding.shared.data.repository.api.TrainingDaysRepository
import com.plcoding.shared.presentation.ui.uistate.TrainingDaysUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TrainingDaysViewModel(
    val trainingDaysRepository: TrainingDaysRepository,
): BaseViewModel() {

    private val _uiState: MutableStateFlow<TrainingDaysUiState> =
        MutableStateFlow(TrainingDaysUiState.Loading)

    val uiState: StateFlow<TrainingDaysUiState> =
        _uiState.asStateFlow()

    init {
        fetchTrainingDays()
    }

    fun fetchTrainingDays() = scope.launch {
        trainingDaysRepository.getTrainingDays().collect { trainingDays ->
            _uiState.update { TrainingDaysUiState.Success(trainingDays) }
        }
    }
}
