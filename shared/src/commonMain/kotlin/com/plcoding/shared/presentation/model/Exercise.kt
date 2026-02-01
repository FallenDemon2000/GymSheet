package com.plcoding.shared.presentation.model

data class Exercise(
    val id: Int?,
    val day: Int,
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
                id = null,
                day = 0,
                name = "Exercise",
                sets = 0,
                reps = 0,
                weight = 0f,
                restTime = 0,
                difficulty = Difficulty.Neutral,
            )
    }
}
