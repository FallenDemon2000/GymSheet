package com.plcoding.shared.data.ktx

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.ui.graphics.vector.ImageVector
import com.plcoding.shared.data.model.ExerciseEntity
import com.plcoding.shared.data.model.TargetMuscle
import com.plcoding.shared.data.model.TrainingDayEntity
import com.plcoding.shared.data.model.TrainingDaysAndExercise
import com.plcoding.shared.presentation.icons.BackDayIcon
import com.plcoding.shared.presentation.icons.ChestDayIcon
import com.plcoding.shared.presentation.icons.LegDayIcon
import com.plcoding.shared.presentation.model.Exercise
import com.plcoding.shared.presentation.model.TrainingDay

fun List<TrainingDaysAndExercise>.mapToTrainingDay(): List<TrainingDay> =
    map { it.trainingDay.toTrainingDay() }

fun List<ExerciseEntity>.mapToExercise(): List<Exercise> =
    map { it.toExercise() }

fun Exercise.mapToEntity(): ExerciseEntity =
    ExerciseEntity(
        id = id,
        day = day,
        name = name,
        sets = sets,
        reps = reps,
        weight = weight,
        restTime = restTime,
        difficulty = difficulty,
    )

private fun TrainingDayEntity.toTrainingDay(): TrainingDay =
    TrainingDay(
        day = day,
        description = description,
        contentDescription = contentDescription,
        icon = target.getIcon(),
    )

private fun ExerciseEntity.toExercise(): Exercise =
    Exercise(
        id = id,
        day = day,
        name = name,
        sets = sets,
        reps = reps,
        weight = weight,
        restTime = restTime,
        difficulty = difficulty,
    )

private fun TargetMuscle.getIcon(): ImageVector =
    when(this) {
        TargetMuscle.BACK -> BackDayIcon
        TargetMuscle.CHEST -> ChestDayIcon
        TargetMuscle.LEGS -> LegDayIcon
        TargetMuscle.UNKNOWN -> Icons.Default.Circle
    }
