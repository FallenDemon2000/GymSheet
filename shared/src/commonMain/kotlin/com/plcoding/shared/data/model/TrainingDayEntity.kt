package com.plcoding.shared.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trainingDay")
data class TrainingDayEntity(
    @PrimaryKey val day: Int,
    val description: String,
    val contentDescription: String,
    val target: TargetMuscle,
)
