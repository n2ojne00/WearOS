package com.example.mykotlinwearos.presentation.theme.responsive

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// SCREEN SIZE DETECTOR
// val screen = rememberWearScreenConfig() using this function

data class WearScreenConfig(
    val isRound: Boolean,
    val isSmall: Boolean, // < 200dp
    val screenWidth: Dp,
    val screenHeight: Dp,
    val horizontalPadding: Dp,
    val verticalPadding: Dp,
    val contentPadding: Dp,
    val debugBorders: Boolean = false //borders for debugging
)

@Composable
fun rememberWearScreenConfig(): WearScreenConfig {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    return remember(screenWidth, screenHeight) {
        val isRound = kotlin.math.abs(screenWidth.value - screenHeight.value) < 10
        val isSmall = screenWidth < 200.dp

        val horizontalPadding = (screenWidth * if (isRound) 0.05f else 0.04f)
        val verticalPadding = (screenHeight * if (isRound) 0.06f else 0.03f)
        val contentPadding = (screenWidth * 0.04f)

        WearScreenConfig(
            isRound = isRound,
            isSmall = isSmall,
            screenWidth = screenWidth,
            screenHeight = screenHeight,
            horizontalPadding = horizontalPadding,
            verticalPadding = verticalPadding,
            contentPadding = contentPadding
        )
    }
}