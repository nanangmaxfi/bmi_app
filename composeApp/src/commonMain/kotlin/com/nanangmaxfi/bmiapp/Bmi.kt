package com.nanangmaxfi.bmiapp

import androidx.compose.ui.graphics.Color

data class BMIResult(
    val score: Float,
    val category: String,
    val color: Color
)

fun calculateBMI(weight: Float, height: Float): BMIResult {
    val heightInMeters = height / 100
    val bmi = weight / (heightInMeters * heightInMeters)
    return when {
        bmi < 18.5 -> BMIResult(bmi, "Kurus", Color(0xFF3498DB))
        bmi < 25 -> BMIResult(bmi, "Normal", Color(0xFF2ECC71))
        bmi < 30 -> BMIResult(bmi, "Kelebihan Berat Badan", Color(0xFFF1C40F))
        else -> BMIResult(bmi, "Obesitas", Color(0xFFE74C3C))
    }
}