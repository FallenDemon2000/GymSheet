package com.plcoding.shared.presentation.model

data class Exercise(
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
