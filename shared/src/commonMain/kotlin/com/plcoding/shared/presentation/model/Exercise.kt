package com.plcoding.shared.presentation.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "exercise", foreignKeys = [
        ForeignKey(
            entity = TrainingDay::class,
            parentColumns = arrayOf("day"),
            childColumns = arrayOf("day"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        )
    ]
)
data class Exercise(
    @PrimaryKey val id: Int? = null,
    @ColumnInfo(index = true) val day: Int,
    val name: String,
    val sets: Int,
    val reps: Int,
    val weight: Float? = null,
    val restTime: Int,
    val difficulty: Difficulty = Difficulty.Neutral,
) {
    companion object {
        val empty
            get() = Exercise(
                name = "Exercise",
                day = 0,
                sets = 0,
                reps = 0,
                weight = 0f,
                restTime = 0,
                difficulty = Difficulty.Neutral,
            )
    }
}
