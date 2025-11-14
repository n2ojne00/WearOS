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
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    val colors = CustomThemeHelper.colors

    var supportsHeartRate by remember { mutableStateOf<Boolean?>(null) }

    val healthClient = HealthServices.getClient(context)
    val measureClient = healthClient.measureClient
    LaunchedEffect(Unit) {
        try {
            val capabilities = measureClient.getCapabilities()
            supportsHeartRate = DataType.HEART_RATE_BPM in capabilities.supportedDataTypesMeasure
        } catch (e: Exception) {
            supportsHeartRate = false
        }
    }
        Text(
            style = AppTypography.body,
            color = colors.textPrimary,
            text = when(supportsHeartRate){
            true -> "Heart rate supported"
            false -> "Heart rate NOT supported"
            null -> "Checking HR.."
        })


}
