package com.plcoding.shared.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.plcoding.shared.presentation.ui.GymSheetAppBar
import com.plcoding.shared.presentation.ui.TrainingDayCard
import com.plcoding.shared.presentation.ui.theme.GymSheetTheme

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = { GymSheetAppBar("Gym Sheet", navController) }
    ) { paddingValues ->
        TrainingDaysList(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        )
    }
}

@Composable
fun TrainingDaysList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        val onCardClick: () -> Unit = {}

        repeat(5) {
            TrainingDayCard(
                onClick = onCardClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
            )
        }
    }
}

@Preview
@Composable
private fun TrainingDaysListPreview() {
    GymSheetTheme {
        HomeScreen(navController = rememberNavController())
    }
}

@Preview
@Composable
private fun TrainingDaysListPreviewDarkTheme() {
    GymSheetTheme(darkTheme = true) {
        HomeScreen(navController = rememberNavController())
    }
}
