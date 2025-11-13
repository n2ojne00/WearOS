package com.example.mykotlinwearos.presentation.components

import androidx.compose.runtime.Composable
import androidx.wear.compose.material.Text
import com.example.mykotlinwearos.presentation.theme.AppTypography
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

//Use this setDate()
@Composable
fun setDate() {
    val date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
    Text(style = AppTypography.body, text = date)
}

// Use this setTime()
@Composable
fun setTime() {
    val time = LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm"))
    Text(style = AppTypography.body, text = time)
}