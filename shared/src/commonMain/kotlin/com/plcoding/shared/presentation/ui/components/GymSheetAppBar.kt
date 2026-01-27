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
import com.plcoding.shared.presentation.ui.theme.GymSheetTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GymSheetAppBar(
    title: String,
    hasPreviousPage: Boolean,
    onBackClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
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
                IconButton(onClick = onBackClick) {
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
            hasPreviousPage = false,
        )
    }
}

@Preview
@Composable
private fun GymSheetAppBarPreviewDarkTheme() {
    GymSheetTheme(darkTheme = true) {
        GymSheetAppBar(
            title = "Gym Sheet",
            hasPreviousPage = true,
        )
    }
}
