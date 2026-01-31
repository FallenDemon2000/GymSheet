package com.plcoding.shared.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.plcoding.shared.presentation.model.Difficulty

@Entity(
    tableName = "exercise", foreignKeys = [
        ForeignKey(
            entity = TrainingDayEntity::class,
            parentColumns = arrayOf("day"),
            childColumns = arrayOf("day"),
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE,
        )
    ]
)
data class ExerciseEntity(
    @PrimaryKey val id: Int? = null,
    @ColumnInfo(index = true) val day: Int,
    val name: String,
    val sets: Int,
    val reps: Int,
    val weight: Float? = null,
    val restTime: Int,
    val difficulty: Difficulty = Difficulty.Neutral,
)
