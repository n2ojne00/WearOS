package com.example.mykotlinwearos.presentation.deviceCapability

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.health.services.client.HealthServices
import androidx.health.services.client.data.DataType
import androidx.health.services.client.getCapabilities
import androidx.wear.compose.material.Text
import com.example.mykotlinwearos.presentation.theme.AppTypography
import com.example.mykotlinwearos.presentation.theme.CustomThemeHelper
import com.example.mykotlinwearos.presentation.theme.responsive.rememberSizeKit


/*
* Check specific health data types if they are supported on device/emulator
*
* */
@Composable
fun CapabilityChecker(context: Context = LocalContext.current) {
    val healthClient = remember { HealthServices.getClient(context) } //access to Health Services API
    val measureClient = remember { healthClient.measureClient } //measure real-time or passive health data

    var supportsHeartRate by remember { mutableStateOf<Boolean?>(null) } //storing if heart rate is supported on device. mutableStateOf for if it changes.
    var supportsSteps by remember { mutableStateOf<Boolean?>(null) }

    var heartRate by remember { mutableStateOf<Int?>(null) }

    val colors = CustomThemeHelper.colors
    val sizeKit = rememberSizeKit()

    //runs once when this composable enters composition
    LaunchedEffect(Unit) {
        try {
            //see what health metrics are supported
            val capabilities = measureClient.getCapabilities()
            //Checks if heart rate is in the list of supported as measurable data types
            supportsHeartRate = DataType.HEART_RATE_BPM in capabilities.supportedDataTypesMeasure
            supportsSteps = DataType.STEPS in capabilities.supportedDataTypesMeasure
            //logCat debugging
            Log.d("HealthCapabilities", "Heart rate supported: $supportsHeartRate")
            Log.d("HealthCapabilities", "Steps: $supportsSteps")

        } catch (e: Exception) {
            Log.e("HealthCapabilities", "Failed to get capabilities", e)
            supportsHeartRate = false
            supportsSteps = false
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(sizeKit.spacingSmall),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(sizeKit.spacingSmall)
    ) {
        Text(
            text = when (supportsHeartRate) {
                true -> "Heart rate supported"
                false -> " Heart rate NOT supported"
                null -> "Checking heart rate..."
            },
            style = AppTypography.body,
            color = colors.textPrimary
        )

        Text(
            text = when (supportsSteps) {
                true -> " Steps supported"
                false -> " Steps NOT supported"
                null -> "Checking steps..."
            },
            style = AppTypography.body,
            color = colors.textPrimary
        )

    }

}