package com.plcoding.shared.presentation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.plcoding.shared.presentation.ui.screens.Screens
import com.plcoding.shared.presentation.ui.theme.GymSheetTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GymSheetAppBar(
    title: String,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val hasPreviousPage = navController.currentDestination?.route != Screens.HOME.route
    val onBackArrowClick: () -> Unit = { navController.popBackStack() }

    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            if (hasPreviousPage)
                IconButton(onClick = onBackArrowClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
        },
    )
}

@Preview
@Composable
private fun GymSheetAppBarPreview() {
    GymSheetTheme {
        GymSheetAppBar(
            title = "Gym Sheet",
            navController = rememberNavController(),
        )
    }
}

@Preview
@Composable
private fun GymSheetAppBarPreviewDarkTheme() {
    GymSheetTheme(darkTheme = true) {
        GymSheetAppBar(
            title = "Gym Sheet",
            navController = rememberNavController(),
        )
    }
}
