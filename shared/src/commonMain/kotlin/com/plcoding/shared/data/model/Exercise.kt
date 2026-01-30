package com.plcoding.shared.data.model

data class Exercise(
    val name: String,
    val sets: Int,
    val reps: Int,
    val weight: Float? = null,
    val restTime: Int,
    val difficulty: Difficulty = Difficulty.Neutral,
){
    companion object {
        val empty
            get() = Exercise(
                name = "Exercise",
                sets = 0,
                reps = 0,
                weight = 0f,
                restTime = 0,
                difficulty = Difficulty.Neutral,
            )
    }
}
