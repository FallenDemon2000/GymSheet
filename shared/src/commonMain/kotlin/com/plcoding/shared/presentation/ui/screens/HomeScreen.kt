package com.plcoding.shared.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.shared.data.model.TrainingDay
import com.plcoding.shared.presentation.ui.components.ErrorMessage
import com.plcoding.shared.presentation.ui.components.GymSheetAppBar
import com.plcoding.shared.presentation.ui.components.LoadingIndicator
import com.plcoding.shared.presentation.ui.components.TrainingDayCard
import com.plcoding.shared.presentation.ui.theme.GymSheetTheme
import com.plcoding.shared.presentation.ui.uistate.TrainingDaysUiState
import com.plcoding.shared.presentation.viewmodel.TrainingDaysViewModel
import org.koin.compose.koinInject

@Composable
fun HomeScreen(
    onNavigate: (Screens) -> Unit,
    trainingDaysViewModel: TrainingDaysViewModel = koinInject(),
) {
    val trainingDaysState by trainingDaysViewModel.uiState.collectAsState()
    val onCardClick: (TrainingDay) -> Unit = { onNavigate(Screens.Exercises(it.day)) }

    Scaffold(topBar = getTopBar()) { paddingValues ->
        when (trainingDaysState) {
            is TrainingDaysUiState.Loading -> {
                LoadingIndicator()
            }

            is TrainingDaysUiState.Error -> {
                val errorState = trainingDaysState as TrainingDaysUiState.Error
                ErrorMessage(message = errorState.message)
            }

            is TrainingDaysUiState.Success -> {
                val state = trainingDaysState as TrainingDaysUiState.Success
                TrainingDaysView(
                    trainingDays = state.trainingDays,
                    onCardClick = onCardClick,
                    paddingValues = paddingValues,
                )
            }
        }
    }
}

@Composable
private fun TrainingDaysView(
    trainingDays: List<TrainingDay>,
    onCardClick: (TrainingDay) -> Unit,
    paddingValues: PaddingValues = PaddingValues(),
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(items = trainingDays) { day ->
            TrainingDayCard(
                trainingDay = day,
                onClick = onCardClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
            )
        }
    }
}

private fun getTopBar(): @Composable (() -> Unit) = {
    GymSheetAppBar(
        title = "Gym Sheet",
        hasPreviousPage = false,
    )
}

@Preview
@Composable
private fun TrainingDaysListPreview() {
    GymSheetTheme {
        TrainingDaysView(
            trainingDays = List(5) { TrainingDay.empty },
            onCardClick = {}
        )
    }
}

@Preview
@Composable
private fun TrainingDaysListPreviewDarkTheme() {
    GymSheetTheme(darkTheme = true) {
        TrainingDaysView(
            trainingDays = List(5) { TrainingDay.empty },
            onCardClick = {}
        )
    }
}
