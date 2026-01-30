package com.plcoding.shared.data.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.plcoding.shared.presentation.icons.BackDayIcon

data class TrainingDay(
    val day: Int,
    val description: String,
    val icon: ImageVector,
    val contentDescription: String,
    val exercises: List<Exercise>,
) {
    companion object {
        val empty
            get() = TrainingDay(
                day = 0,
                description = "description",
                icon = BackDayIcon,
                contentDescription = "content description",
                exercises = emptyList()
            )
    }
}
