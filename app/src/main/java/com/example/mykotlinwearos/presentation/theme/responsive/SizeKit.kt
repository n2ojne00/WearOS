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

    // Buttons
    val buttonSmall: Dp,
    val buttonMedium: Dp,
    val buttonLarge: Dp,

    //Screen space
    val halfScreen: Dp,
    val quarterScreen: Dp,
    val threeQuarterScreen: Dp,
    val halfWidth: Dp,
    val fullWidth: Dp
)

//Minimum touch target 48 dp x 48 dp <-
//An element such as an icon may appear to be 24dp x 24dp, but the padding surrounding it can make up the full 48 x 48 dp touch target.
//there are some situations where 40dp x 40dp is allowed.


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
        spacingSmall = (2 * scale).dp,
        spacingMedium = (3 * scale).dp,
        spacingLarge = (5 * scale).dp,

        //ICON SIZES
        iconSmall = (25 * scale).dp,
        iconMedium = (32 * scale).dp,
        iconLarge = (48 * scale).dp,

        //Button sizes
        buttonSmall = (48 * scale).dp,
        buttonMedium = (72 * scale).dp,
        buttonLarge = (96 * scale).dp,

        //ScreenSpace
        halfScreen = screen.screenHeight * 0.5f,
        quarterScreen = screen.screenHeight * 0.25f,
        threeQuarterScreen = screen.screenHeight * 0.75f,

        halfWidth = screen.screenWidth * 0.5f,
        fullWidth = screen.screenWidth * 1.0f
    )
}