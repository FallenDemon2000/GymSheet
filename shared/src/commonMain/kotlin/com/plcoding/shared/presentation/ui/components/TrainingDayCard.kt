package com.plcoding.shared.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.shared.presentation.icons.BackDayIcon
import com.plcoding.shared.presentation.model.TrainingDay
import com.plcoding.shared.presentation.ui.Dimens
import com.plcoding.shared.presentation.ui.theme.GymSheetTheme

@Composable
fun TrainingDayCard(
    trainingDay: TrainingDay,
    onClick: (TrainingDay) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(onClick = { onClick(trainingDay) }, modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(2.dp),
            ) {
                Text(
                    text = "Day ${trainingDay.day}",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = trainingDay.description,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            Icon(
                imageVector = trainingDay.icon,
                contentDescription = trainingDay.contentDescription,
                tint = Color.Unspecified,
                modifier = Modifier.height(Dimens.TrainingDayIcon),
            )
        }
    }
}

@Preview
@Composable
private fun TrainingDayCardPreview() {
    GymSheetTheme {
        TrainingDayCard(
            trainingDay = TrainingDay.empty,
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
private fun TrainingDayCardPreviewDarkTheme() {
    GymSheetTheme(darkTheme = true) {
        TrainingDayCard(
            trainingDay = TrainingDay.empty,
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
