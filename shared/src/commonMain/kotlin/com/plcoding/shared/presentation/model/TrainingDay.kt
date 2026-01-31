package com.plcoding.shared.presentation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.ui.graphics.vector.ImageVector

data class TrainingDay(
    val day: Int,
    val description: String,
    val contentDescription: String,
    val icon: ImageVector,
) {
    companion object {
        val empty
            get() = TrainingDay(
                day = 0,
                description = "description",
                contentDescription = "content description",
                icon = Icons.Default.Circle,
            )
    }
}
