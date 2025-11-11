package com.example.mykotlinwearos.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


// Customized theme data
// val colors = CustomThemeHelper.colors

data class CustomTheme(
    val background: Color,
    val overlayBg: Color,

    val textPrimary: Color, //Grey
    val textSecondary: Color, //Grey-green darker
    val textHighlight: Color, //bright blue
    val textHighlightOff: Color, //darker blue
    val textWhite: Color,
    val textBlack: Color,
    val textError: Color,
    val textSuccess: Color,

    val iconPrimary: Color, //blue
    val iconSecondary: Color, //deeperBlue
    val iconWhite: Color,
    val iconError: Color, //bright red

    //background colors
    val buttonMain: Color,
    val iconAcceptBg: Color, //bright green
    val iconDeclineBg: Color, //red

    val isLight: Boolean,
)

// Dark theme colors
val darkThemeColors = CustomTheme(
    background = Color(0xFF000000),
    overlayBg = Color(0xDF000000),


    textPrimary = Color(0xFFCDE0D0),
    textSecondary = Color(0xFFB3C6B8),
    textHighlight = Color(0xFF4AA8FF),
    textHighlightOff = Color(0xFF2E78C6),
    textWhite = Color(0xFFFFFFFF),
    textBlack = Color(0xFF000000),
    textError = Color(0xFFF7637E),
    textSuccess = Color(0xFF4E8E64),

    iconPrimary = Color(0xFF2E78C6),
    iconSecondary = Color(0xFF214D6E),
    iconWhite = Color(0xFFFFFFFF),
    iconError = Color(0xFFF7637E),

    buttonMain = Color(0xFF3C9AF8),
    iconAcceptBg = Color(0xFF14D25A),
    iconDeclineBg = Color(0xFFAE001D),

    isLight = false
)

// Light theme colors
val lightThemeColors = CustomTheme(
    background = Color(0xFFFCF8F2),
    overlayBg = Color(0xDFFCF8F2),

    textPrimary = Color(0xFF232724),
    textSecondary = Color(0xFF34493B),
    textHighlight = Color(0xFF2E78C6), //check visibility
    textHighlightOff = Color(0xFF214D6E),  //check visibility
    textWhite = Color(0xFFFFFFFF),
    textBlack = Color(0xFF000000),
    textError = Color(0xFFC1263C),
    textSuccess = Color(0xFF3C6B4E),

    iconPrimary = Color(0xFF2E78C6),
    iconSecondary = Color(0xFF204E76),
    iconWhite = Color(0xFFFFFFFF),
    iconError = Color(0xFFC1263C),

    buttonMain = Color(0xFF3C9AF8),
    iconAcceptBg = Color(0xFF14D25A),
    iconDeclineBg = Color(0xFFAE001D),

    isLight = true
)

val LocalCustomColors = staticCompositionLocalOf<CustomTheme> {
    error("No CustomTheme provided")
}
object CustomThemeHelper {
    val colors: CustomTheme
        @Composable
        get() = LocalCustomColors.current
}



// ---------- COLOR LIBRARY ---------- //

// Screens (backgrounds)
val ScreenDark = Color(0xFF000000)
val ScreenLight = Color(0xFFFCF8F2)

// Main colors (primary palette)
val MainBlue = Color(0xFF2E78C6)
val MainRed = Color(0xFFE23E5A)
val MainGrey = Color(0xFF98A39C)
val MainGreen = Color(0xFF3C6B4E)

// Dark shades
val darkLight3 = Color(0xFF4AA8FF)
val darkLight2 = Color(0xFF2F95F7)
val MainBlueDark = Color(0xFF2E78C6) //MAIN
val Dark2 = Color(0xFF214D6E)
val Dark3 = Color(0xFF193F58)

// Light shades
val lightDark3 = Color(0xFF18334A)
val lightDark2 = Color(0xFF204E76)
val MainBlueLight = Color(0xFF2E78C6) //MAIN
val Light2 = Color(0xFF3C9AF8)
val Light3 = Color(0xFF5DB5FF)

// Reds
val RedDark3 = Color(0xFF8A1E32)
val RedDark2 = Color(0xFFC1263C)
val Red = Color(0xFFE23E5A) //MAIN
val RedLight2 = Color(0xFFF7637E)
val RedLight3 = Color(0xFFFF8CA4)

// Greys
val GreyDark3 = Color(0xFF6B6B6B)
val GreyDark2 = Color(0xFF8A8A8A)
val Grey = Color(0xFF98A39C) //MAIN
val GreyLight2 = Color(0xFFB3C6B8)
val GreyLight3 = Color(0xFFCDE0D0)

// Greens
val GreenDark3 = Color(0xFF232724)
val GreenDark2 = Color(0xFF34493B)
val Green = Color(0xFF3C6B4E) //MAIN
val GreenLight2 = Color(0xFF4E8E64)
val GreenLight3 = Color(0xFF63B67E)

//Notify colors
val AcceptGreen = Color(0xFF14D25A)
val DeclineRed = Color(0xFFAE001D)
