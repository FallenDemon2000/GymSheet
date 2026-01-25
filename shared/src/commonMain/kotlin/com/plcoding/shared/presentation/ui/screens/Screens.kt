package com.plcoding.shared.presentation.ui.screens

import kotlinx.serialization.Serializable

sealed interface Screens {

    @Serializable
    data object Home : Screens

    @Serializable
    data class Exercises(val trainingDay: Int) : Screens
}
