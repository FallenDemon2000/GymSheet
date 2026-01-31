package com.plcoding.shared.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trainingDay")
data class TrainingDay(
    @PrimaryKey val day: Int,
    val description: String,
    val contentDescription: String,
    val target: TargetMuscle,
) {
    companion object {
        val empty
            get() = TrainingDay(
                day = 0,
                description = "description",
                contentDescription = "content description",
                target = TargetMuscle.UNKNOWN,
            )
    }
}
