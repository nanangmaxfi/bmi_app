package com.nanangmaxfi.bmiapp

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Home : Screen()

    @Serializable
    data class Detail(val id: String) : Screen()
}