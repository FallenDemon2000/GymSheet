package com.plcoding.shared.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.shared.presentation.model.Exercise
import com.plcoding.shared.presentation.ui.components.ErrorMessage
import com.plcoding.shared.presentation.ui.components.ExerciseExpandableCard
import com.plcoding.shared.presentation.ui.components.GymSheetAppBar
import com.plcoding.shared.presentation.ui.components.LoadingIndicator
import com.plcoding.shared.presentation.ui.theme.GymSheetTheme
import com.plcoding.shared.presentation.ui.uistate.ExercisesUiState
import com.plcoding.shared.presentation.viewmodel.ExercisesViewModel
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

@Composable
fun ExercisesScreen(
    trainingDay: Int,
    onBackClick: () -> Unit,
    exercisesViewModel: ExercisesViewModel = koinInject { parametersOf(trainingDay) },
) {
    val exercisesState by exercisesViewModel.uiState.collectAsState()

    Scaffold(topBar = getTopBar(trainingDay, onBackClick)) { paddingValues ->
        when (exercisesState) {
            is ExercisesUiState.Loading -> {
                LoadingIndicator()
            }

            is ExercisesUiState.Error -> {
                val errorState = exercisesState as ExercisesUiState.Error
                ErrorMessage(message = errorState.message)
            }

            is ExercisesUiState.Success -> {
                val state = exercisesState as ExercisesUiState.Success
                ExercisesView(
                    exercises = state.exercises,
                    paddingValues = paddingValues,
                )
            }
        }
    }
}

@Composable
private fun ExercisesView(
    exercises: List<Exercise>,
    paddingValues: PaddingValues = PaddingValues(),
) {
    var expandedCardIndex by remember { mutableStateOf(-1) }

    val onCardClick: (Int) -> Unit = {
        expandedCardIndex =
            if(expandedCardIndex == it) -1 else it
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        itemsIndexed(items = exercises) { index, exercise ->
            ExerciseExpandableCard(
                exercise = exercise,
                isExpanded = expandedCardIndex == index,
                onCardClick = { onCardClick(index) },
                onPlusClick = {},
                onMinusClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
            )
        }
    }
}

private fun getTopBar(day: Int, onBackClick: () -> Unit): @Composable (() -> Unit) = {
    GymSheetAppBar(
        title = "Day $day",
        hasPreviousPage = true,
        onBackClick = onBackClick,
    )
}

@Preview
@Composable
private fun ExercisesScreenPreview() {
    GymSheetTheme {
        ExercisesView(
            exercises = List(7) { Exercise.empty },
        )
    }
}

@Preview
@Composable
private fun ExercisesScreenPreviewDarkTheme() {
    GymSheetTheme(darkTheme = true) {
        ExercisesView(
            exercises = List(7) { Exercise.empty },
        )
    }
}
