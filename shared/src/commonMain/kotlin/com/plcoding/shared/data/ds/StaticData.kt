package com.plcoding.shared.data.ds

import com.plcoding.shared.presentation.icons.BackDayIcon
import com.plcoding.shared.presentation.icons.ChestDayIcon
import com.plcoding.shared.presentation.icons.LegDayIcon
import com.plcoding.shared.data.model.Difficulty
import com.plcoding.shared.data.model.Exercise
import com.plcoding.shared.data.model.TrainingDay

object StaticData {
    val staticTrainingDays
        get() = listOf(
            TrainingDay(
                day = 1,
                description = "Back and Biceps training",
                icon = BackDayIcon,
                contentDescription = "Back Day Icon",
                exercises = staticExercises,
            ),
            TrainingDay(
                day = 2,
                description = "Chest and Triceps training",
                icon = ChestDayIcon,
                contentDescription = "Chest Day Icon",
                exercises = staticExercises,
            ),
            TrainingDay(
                day = 3,
                description = "Legs training",
                icon = LegDayIcon,
                contentDescription = "Legs Day Icon",
                exercises = staticExercises,
            ),
        )

    val staticExercises
        get() = listOf(
            Exercise(
                name = "Pull-ups",
                sets = 3,
                reps = 12,
                restTime = 5,
                difficulty = Difficulty.Hard,
            ),
            Exercise(
                name = "Back Rows",
                sets = 3,
                reps = 12,
                weight = 55f,
                restTime = 5,
            ),
            Exercise(
                name = "Lower Back",
                sets = 3,
                reps = 12,
                weight = 40f,
                restTime = 5,
                difficulty = Difficulty.Easy,
            ),
            Exercise(
                name = "W Bar Curls",
                sets = 3,
                reps = 12,
                weight = 7.5f,
                restTime = 5,
                difficulty = Difficulty.Hard
            ),
            Exercise(
                name = "Hammer Curls",
                sets = 3,
                reps = 12,
                weight = 7.5f,
                restTime = 5,
                difficulty = Difficulty.Easy,
            ),
            Exercise(
                name = "Treadmill Sprints",
                sets = 3,
                reps = 2,
                restTime = 1,
            ),
        )
}
