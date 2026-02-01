package com.plcoding.shared.presentation.viewmodel

import com.plcoding.shared.BaseViewModel
import com.plcoding.shared.data.repository.api.TrainingDaysRepository
import com.plcoding.shared.presentation.model.Exercise
import com.plcoding.shared.presentation.ui.uistate.ExercisesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ExercisesViewModel(
    trainingDay: Int,
    private val trainingDaysRepository: TrainingDaysRepository,
) : BaseViewModel() {

    private val _uiState: MutableStateFlow<ExercisesUiState> =
        MutableStateFlow(ExercisesUiState.Loading)

    val uiState: StateFlow<ExercisesUiState> =
        _uiState.asStateFlow()

    init {
        fetchExercises(trainingDay)
    }

    fun fetchExercises(trainingDay: Int) = scope.launch {
        trainingDaysRepository.getExercises(trainingDay).collect { exercises ->
            _uiState.update {
                exercises.takeIf { it.isNotEmpty() }
                    ?.let { ExercisesUiState.Success(exercises = it) }
                    ?: ExercisesUiState.Error(message = "No exercises for this day")
            }
        }
    }

    fun updateExercise(exercise: Exercise) = scope.launch {
        trainingDaysRepository.updateExercise(exercise)
    }
}
