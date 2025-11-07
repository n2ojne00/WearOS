package com.example.mykotlinwearos.presentation.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mykotlinwearos.R


val NotoSans = FontFamily(
    Font(R.font.noto_sans_regular, FontWeight.Normal),
    Font(R.font.noto_sans_medium, FontWeight.Medium),
    Font(R.font.noto_sans_bold, FontWeight.Bold)
)

// Customized typography structure
data class CustomTypography(
    val header: TextStyle,
    val title: TextStyle,
    val body: TextStyle,
    val numberSmall: TextStyle,
    val numberNormal: TextStyle,
    val numberLarge: TextStyle
)

// typography styles
val AppTypography = CustomTypography(
    header = TextStyle(
        fontFamily = NotoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 26.sp
    ),
    title = TextStyle(
        fontFamily = NotoSans,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 22.sp
    ),
    body = TextStyle(
        fontFamily = NotoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 18.sp
    ),
    numberSmall = TextStyle(
        fontFamily = NotoSans,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 36.sp
    ),
    numberNormal = TextStyle(
        fontFamily = NotoSans,
        fontWeight = FontWeight.Medium,
        fontSize = 25.sp,
        lineHeight = 36.sp
    ),
    numberLarge = TextStyle(
        fontFamily = NotoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        lineHeight = 56.sp
    )
)
