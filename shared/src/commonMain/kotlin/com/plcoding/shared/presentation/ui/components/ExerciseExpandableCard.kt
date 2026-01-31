package com.plcoding.shared.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.shared.ktx.formatNumber
import com.plcoding.shared.data.model.Exercise
import com.plcoding.shared.presentation.ui.theme.GymSheetTheme

@Composable
fun ExerciseExpandableCard(
    exercise: Exercise,
    isExpanded: Boolean,
    onCardClick: () -> Unit,
    onPlusClick: () -> Unit,
    onMinusClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var showEditDialog by remember { mutableStateOf(false) }
    val onEditClick: () -> Unit = { showEditDialog = true }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        IconButton(onClick = onMinusClick) {
            Icon(
                imageVector = Icons.Default.Remove,
                contentDescription = "Edit icon",
                tint = MaterialTheme.colorScheme.surfaceContainer,
            )
        }
        ExerciseCard(
            exercise = exercise,
            onClick = onCardClick,
            isExpanded = isExpanded,
            modifier = Modifier.weight(1f),
        )
        Column {
            IconButton(onClick = onPlusClick) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Edit icon",
                    tint = MaterialTheme.colorScheme.surfaceContainer,
                )
            }
            if (isExpanded) {
                IconButton(onClick = onEditClick) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit icon",
                        tint = MaterialTheme.colorScheme.surfaceContainer,
                    )
                }
            }
        }
    }
}

@Composable
private fun ExerciseCard(
    exercise: Exercise,
    onClick: () -> Unit,
    isExpanded: Boolean = false,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Card(modifier = Modifier.fillMaxWidth(), onClick = onClick) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = exercise.name,
                    style = MaterialTheme.typography.titleMedium,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f),
                )
                if (exercise.weight != null) {
                    Text(
                        text = "${formatNumber(exercise.weight)} Kg",
                        style = MaterialTheme.typography.titleMedium,
                    )
                }
            }
        }
        if (isExpanded) {
            ExerciseDetails(
                sets = exercise.sets,
                repetitions = exercise.reps,
                restingTime = exercise.restTime,
                modifier = Modifier
            )
        }
    }
}

@Composable
private fun ExerciseDetails(
    sets: Int,
    repetitions: Int,
    restingTime: Int,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        ExerciseDescription(
            sets = sets,
            repetitions = repetitions,
            restingTime = restingTime,
            modifier = Modifier
                .bottomBorder(MaterialTheme.colorScheme.surfaceContainer)
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .weight(1f),
        )
    }
}

@Composable
private fun ExerciseDescription(
    sets: Int,
    repetitions: Int,
    restingTime: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        ExerciseField(field = "Sets", value = sets)
        ExerciseField(field = "Reps", value = repetitions)
        HorizontalDivider(modifier = Modifier.fillMaxWidth())
        ExerciseField(field = "Rest Time", value = restingTime)
    }
}

@Composable
private fun ExerciseField(
    field: String,
    value: Int,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        Text(
            text = field,
            modifier = Modifier.weight(1f),
        )
        Text(
            text = value.toString(),
        )
    }
}

private fun Modifier.bottomBorder(color: Color) =
    drawBehind {
        val strokeWidth = 2 * density
        val y = size.height - strokeWidth / 2

        drawLine(
            color = color,
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = 0f, y = y),
            strokeWidth = strokeWidth
        )

        drawLine(
            color = color,
            start = Offset(x = 0f, y = y),
            end = Offset(x = size.width, y = y),
            strokeWidth = strokeWidth
        )

        drawLine(
            color = color,
            start = Offset(x = size.width, y = y),
            end = Offset(x = size.width, y = 0f),
            strokeWidth = strokeWidth
        )
    }

@Preview
@Composable
private fun ExerciseExpandableCardPreview() {
    GymSheetTheme {
        ExerciseExpandableCard(
            exercise = Exercise.empty,
            isExpanded = false,
            onCardClick = {},
            onPlusClick = {},
            onMinusClick = {},
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview
@Composable
private fun ExerciseExpandableCardPreviewDarkTheme() {
    GymSheetTheme(darkTheme = true) {
        ExerciseExpandableCard(
            exercise = Exercise.empty,
            isExpanded = true,
            onCardClick = {},
            onPlusClick = {},
            onMinusClick = {},
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
