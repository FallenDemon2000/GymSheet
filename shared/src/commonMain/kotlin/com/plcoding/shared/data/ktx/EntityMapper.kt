package com.plcoding.shared.data.ktx

import com.plcoding.shared.data.model.ExerciseEntity
import com.plcoding.shared.data.model.TargetMuscle
import com.plcoding.shared.data.model.TrainingDayEntity
import com.plcoding.shared.data.model.TrainingDaysAndExercise
import com.plcoding.shared.presentation.model.Exercise
import com.plcoding.shared.presentation.model.TrainingDay

fun List<TrainingDaysAndExercise>.mapToTrainingDay(): List<TrainingDay> =
    map { it.trainingDay.toTrainingDay() }

fun List<ExerciseEntity>.mapToExercise(): List<Exercise> =
    map { it.toExercise() }

private fun TrainingDayEntity.toTrainingDay(): TrainingDay =
    TrainingDay(
        day = day,
        description = description,
        contentDescription = contentDescription,
        target = target,
    )

private fun ExerciseEntity.toExercise(): Exercise =
    Exercise(
        day = day,
        name = name,
        sets = sets,
        reps = reps,
        weight = weight,
        restTime = restTime,
        difficulty = difficulty,
    )
