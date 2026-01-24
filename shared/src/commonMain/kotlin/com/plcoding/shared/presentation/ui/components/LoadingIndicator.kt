package com.plcoding.shared.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.shared.presentation.ui.theme.GymSheetTheme

@Composable
fun LoadingIndicator() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
    ) {
        CircularProgressIndicator(
            strokeWidth = 4.dp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview
@Composable
fun LoadingIndicatorPreview() {
    GymSheetTheme {
        LoadingIndicator()
    }
}

@Preview
@Composable
fun LoadingIndicatorPreviewDarkTheme() {
    GymSheetTheme(darkTheme = true) {
        LoadingIndicator()
    }
}
