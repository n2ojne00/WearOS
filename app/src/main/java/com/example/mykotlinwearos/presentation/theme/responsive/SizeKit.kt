package com.example.mykotlinwearos.presentation.theme.responsive

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

data class SizeKit(
    val navButtonSize: Dp,
    val navIconSize: Dp,

    // Spacing
    val spacingSmall: Dp,
    val spacingMedium: Dp,
    val spacingLarge: Dp,

    // Icons
    val iconSmall: Dp,
    val iconMedium: Dp,
    val iconLarge: Dp,

    // Fonts
    val fontSmall: TextUnit,
    val fontBody: TextUnit,
    val fontLarge: TextUnit,

    // Buttons
    val buttonSmall: Dp,
    val buttonMedium: Dp,
    val buttonLarge: Dp
)

//USE REMEMBER SIZE KIT -> val sizeKit = rememberSizeKit()
@Composable
fun rememberSizeKit(): SizeKit {
    val screen = rememberWearScreenConfig()

    // Scale factor based on screen width
    val scale = screen.screenWidth.value / 200f  // base 200dp reference

    return SizeKit(

        //NAVIGATION
        navButtonSize = (screen.screenWidth * 0.6f),
        navIconSize = (screen.screenWidth * 0.45f),

        //SPACING SCALE
        spacingSmall = (4 * scale).dp,
        spacingMedium = (6 * scale).dp,
        spacingLarge = (8 * scale).dp,

        //ICON SIZES
        iconSmall = (25 * scale).dp,
        iconMedium = (32 * scale).dp,
        iconLarge = (48 * scale).dp,

        //FONT SIZE -> is it needed?
        fontSmall = (10 * scale).sp,
        fontBody = (14 * scale).sp,
        fontLarge = (20 * scale).sp,

        //Button sizes
        buttonSmall = (48 * scale).dp,
        buttonMedium = (72 * scale).dp,
        buttonLarge = (96 * scale).dp
    )
}