package com.plcoding.shared.data.ds

import com.plcoding.shared.data.model.ExerciseEntity
import com.plcoding.shared.data.model.TargetMuscle
import com.plcoding.shared.data.model.TrainingDayEntity
import com.plcoding.shared.presentation.model.Difficulty

object StaticData {
    val staticTrainingDays
        get() = arrayOf(backDay, chestDay, legDay)

    val staticExercises
        get() = arrayOf(*backExercises, *chestExercises, *legExercises)

    // BACK DAY EXERCISES
    private val backDay =
        TrainingDayEntity(
            day = 1,
            description = "Back and Biceps training",
            contentDescription = "Back Day Icon",
            target = TargetMuscle.BACK,
        )

    private val backExercises: Array<ExerciseEntity> = arrayOf(
        ExerciseEntity(day = backDay.day, name = "Pull-ups", sets = 5, reps = 12, weight = null, restTime = 5, difficulty = Difficulty.Hard),
        ExerciseEntity(day = backDay.day, name = "Back Rows", sets = 3, reps = 12, weight = 55f, restTime = 3, difficulty = Difficulty.Neutral),
        ExerciseEntity(day = backDay.day, name = "Lower Back", sets = 3, reps = 12, weight = 40f, restTime = 3, difficulty = Difficulty.Easy),
        ExerciseEntity(day = backDay.day, name = "W Bar Curls", sets = 3, reps = 12, weight = 7.5f, restTime = 2, difficulty = Difficulty.Hard),
        ExerciseEntity(day = backDay.day, name = "Hammer Curls", sets = 3, reps = 12, weight = 7.5f, restTime = 2, difficulty = Difficulty.Easy),
        ExerciseEntity(day = backDay.day, name = "Treadmill Sprints", sets = 3, reps = 2, weight = null, restTime = 1, difficulty = Difficulty.Neutral),
    )

    // CHEST DAY EXERCISES
    private val chestDay =
        TrainingDayEntity(
            day = 2,
            description = "Chest and Triceps training",
            contentDescription = "Chest Day Icon",
            target = TargetMuscle.CHEST,
        )

    private val chestExercises: Array<ExerciseEntity> = arrayOf(
        ExerciseEntity(day = chestDay.day, name = "Bench Press", sets = 3, reps = 10, weight = 22.5f, restTime = 3, difficulty = Difficulty.Easy),
        ExerciseEntity(day = chestDay.day, name = "Dips", sets = 3, reps = 10, weight = null, restTime = 3, difficulty = Difficulty.Neutral),
        ExerciseEntity(day = chestDay.day, name = "Peck Deck", sets = 2, reps = 12, weight = 52.5f, restTime = 2, difficulty = Difficulty.Easy),
        ExerciseEntity(day = chestDay.day, name = "Shoulder Press", sets = 2, reps = 12, weight = 17.5f, restTime = 2, difficulty = Difficulty.Neutral),
        ExerciseEntity(day = chestDay.day, name = "Kickback triceps", sets = 3, reps = 12, weight = 20f, restTime = 2, difficulty = Difficulty.Hard),
        ExerciseEntity(day = chestDay.day, name = "Overhead triceps", sets = 3, reps = 12, weight = 20f, restTime = 2, difficulty = Difficulty.Neutral),
        ExerciseEntity(day = chestDay.day, name = "Treadmill Sprints", sets = 3, reps = 2, weight = null, restTime = 1, difficulty = Difficulty.Neutral),
    )

    // LEG DAY EXERCISES
    private val legDay =
        TrainingDayEntity(
            day = 3,
            description = "Leg training",
            contentDescription = "Leg Day Icon",
            target = TargetMuscle.LEGS,
        )

    private val legExercises: Array<ExerciseEntity> = arrayOf(
        ExerciseEntity(day = legDay.day, name = "Squats", sets = 4, reps = 10, weight = 25f, restTime = 3, difficulty = Difficulty.Easy),
        ExerciseEntity(day = legDay.day, name = "Leg Press", sets = 3, reps = 10, weight = 65f, restTime = 3, difficulty = Difficulty.Easy),
        ExerciseEntity(day = legDay.day, name = "Leg Curls", sets = 3, reps = 12, weight = 52.5f, restTime = 2, difficulty = Difficulty.Easy),
        ExerciseEntity(day = legDay.day, name = "Leg extensions", sets = 2, reps = 12, weight = 70f, restTime = 2, difficulty = Difficulty.Easy),
        ExerciseEntity(day = legDay.day, name = "Hip abductor", sets = 3, reps = 12, weight = 80f, restTime = 2, difficulty = Difficulty.Easy),
        ExerciseEntity(day = legDay.day, name = "Abs workout", sets = 3, reps = 12, weight = null, restTime = 2, difficulty = Difficulty.Neutral),
    )
}
