package com.plcoding.shared.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class TrainingDaysAndExercise(
    @Embedded
    val trainingDay: TrainingDayEntity,

    @Relation(parentColumn = "day", entityColumn = "day")
    val exercises: List<ExerciseEntity>,
)
