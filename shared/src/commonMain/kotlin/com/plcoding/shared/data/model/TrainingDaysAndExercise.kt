package com.plcoding.shared.data.model

import androidx.room.Embedded
import androidx.room.Relation
import com.plcoding.shared.presentation.model.Exercise
import com.plcoding.shared.presentation.model.TrainingDay

data class TrainingDaysAndExercise(
    @Embedded
    val trainingDay: TrainingDay,

    @Relation(parentColumn = "day", entityColumn = "day")
    val exercises: List<Exercise>,
)
