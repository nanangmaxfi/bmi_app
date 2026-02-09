package com.nanangmaxfi.bmiapp.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nanangmaxfi.bmiapp.calculateBMI
import kotlin.math.roundToInt

@Composable
fun BMIScreen() {
    var weight by remember { mutableStateOf(60f) }
    var height by remember { mutableStateOf(165f) }

    val result = calculateBMI(weight, height)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Kalkulator BMI",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Card Hasil BMI
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            colors = CardDefaults.cardColors(containerColor = result.color.copy(alpha = 0.1f)),
            shape = RoundedCornerShape(24.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = ((result.score * 10).roundToInt() / 10.0).toString(),
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Black,
                    color = result.color
                )
                Text(
                    text = result.category,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = result.color
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Input Tinggi Badan
        InputSlider(
            label = "Tinggi Badan",
            value = height,
            range = 100f..220f,
            unit = "cm",
            onValueChange = { height = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Input Berat Badan
        InputSlider(
            label = "Berat Badan",
            value = weight,
            range = 30f..150f,
            unit = "kg",
            onValueChange = { weight = it }
        )
    }
}

@Composable
fun InputSlider(
    label: String,
    value: Float,
    range: ClosedFloatingPointRange<Float>,
    unit: String,
    onValueChange: (Float) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = label, fontWeight = FontWeight.SemiBold)
            Text(text = "${value.roundToInt()} $unit", color = MaterialTheme.colorScheme.primary)
        }
        Slider(
            value = value,
            onValueChange = onValueChange,
            valueRange = range,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview
@Composable
fun BMIScreenPreview(){
    MaterialTheme {
        BMIScreen()
    }
}