package com.plcoding.shared

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.plcoding.shared.presentation.ui.screens.ExercisesScreen
import com.plcoding.shared.presentation.ui.screens.HomeScreen
import com.plcoding.shared.presentation.ui.screens.Screens

@Composable
@Preview
fun AppScaffold() {
    Scaffold {
        AppNavHost(
            navController = rememberNavController(),
            modifier = Modifier.fillMaxSize(),
        )
    }
}

@Composable
private fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val onNavigate:(Screens) -> Unit = { screen -> navController.navigate(screen) }
    val onBackClick: () -> Unit = { navController.popBackStack() }

    NavHost(
        navController = navController,
        startDestination = Screens.Home,
        modifier = modifier,
    ) {
        composable<Screens.Home> {
            HomeScreen(onNavigate = onNavigate)
        }
        composable<Screens.Exercises> { navBackStackEntry ->
            val trainingDay = navBackStackEntry.toRoute<Screens.Exercises>().trainingDay
            ExercisesScreen(trainingDay = trainingDay, onBackClick = onBackClick)
        }
    }
}
