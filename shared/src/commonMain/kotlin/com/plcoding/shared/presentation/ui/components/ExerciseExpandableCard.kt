package com.plcoding.shared.presentation.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.shared.ktx.formatNumber
import com.plcoding.shared.presentation.model.Difficulty
import com.plcoding.shared.presentation.model.Exercise
import com.plcoding.shared.presentation.ui.theme.GymSheetTheme

@Composable
fun ExerciseExpandableCard(
    exercise: Exercise,
    isExpanded: Boolean,
    onCardClick: () -> Unit,
    onPlusClick: (Exercise) -> Unit,
    onMinusClick: (Exercise) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        ExerciseCard(
            exercise = exercise,
            onClick = onCardClick,
            modifier = Modifier.fillMaxWidth()
                .difficultyShadow(shape = CardDefaults.shape, difficulty = exercise.difficulty)
        )
        if (isExpanded) {
            ExerciseDetails(
                exercise = exercise,
                onPlusClick = onPlusClick,
                onMinusClick = onMinusClick,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
private fun ExerciseCard(
    exercise: Exercise,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier, onClick = onClick) {
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
}

@Composable
private fun ExerciseDetails(
    exercise: Exercise,
    onPlusClick: (Exercise) -> Unit,
    onMinusClick: (Exercise) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        if (exercise.weight != null) {
            IconButton(onClick = { onMinusClick(exercise) }) {
                Icon(
                    imageVector = Icons.Default.Remove,
                    contentDescription = "Edit icon",
                )
            }
        }
        ExerciseDescription(
            sets = exercise.sets,
            repetitions = exercise.reps,
            restingTime = exercise.restTime,
            modifier = Modifier
                .bottomBorder(MaterialTheme.colorScheme.surfaceContainer)
                .padding(horizontal = 16.dp, vertical = 6.dp)
                .weight(1f),
        )
        if (exercise.weight != null) {
            IconButton(onClick = { onPlusClick(exercise) }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Edit icon",
                )
            }
        }
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

private fun Modifier.bottomBorder(color: Color): Modifier =
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

private fun Modifier.difficultyShadow(
    shape: Shape,
    difficulty: Difficulty,
): Modifier =
    dropShadow(
        shape = shape,
        shadow = Shadow(
            radius = 4.dp,
            alpha = 0.5f,
            color = when (difficulty) {
                Difficulty.Easy -> Color.Green
                Difficulty.Hard -> Color.Red
                else -> Color.Transparent
            },
        ),
    )

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
