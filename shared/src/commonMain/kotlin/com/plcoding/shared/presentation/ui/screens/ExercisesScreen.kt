package com.plcoding.shared.presentation.ui.screens

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.shared.presentation.ui.components.GymSheetAppBar
import com.plcoding.shared.presentation.ui.components.LoadingIndicator
import com.plcoding.shared.presentation.ui.theme.GymSheetTheme

@Composable
fun ExercisesScreen(
    trainingDay: Int,
    onBackClick: () -> Unit,
) {
    Scaffold(topBar = getTopBar(trainingDay, onBackClick)) { paddingValues ->
        LoadingIndicator()
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
        ExercisesScreen(
            trainingDay = 0,
            onBackClick = {},
        )
    }
}

@Preview
@Composable
private fun ExercisesScreenPreviewDarkTheme() {
    GymSheetTheme(darkTheme = true) {
        ExercisesScreen(
            trainingDay = 0,
            onBackClick = {},
        )
    }
}
