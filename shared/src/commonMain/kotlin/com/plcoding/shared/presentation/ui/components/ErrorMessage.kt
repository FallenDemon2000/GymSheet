package com.plcoding.shared.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.plcoding.shared.presentation.ui.theme.GymSheetTheme

@Composable
fun ErrorMessage(message: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
    ) {
        Text(
            text = message,
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview
@Composable
private fun ErrorMessagePreview() {
    GymSheetTheme {
        ErrorMessage("Error Message")
    }
}

@Preview
@Composable
private fun ErrorMessagePreviewDarkTheme() {
    GymSheetTheme(darkTheme = true) {
        ErrorMessage("Error Message")
    }
}
