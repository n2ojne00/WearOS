package com.example.mykotlinwearos.presentation.screens.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import com.example.mykotlinwearos.presentation.theme.AppTypography
import com.example.mykotlinwearos.presentation.theme.CustomThemeHelper
import com.example.mykotlinwearos.presentation.theme.responsive.rememberSizeKit

@Composable
fun OverlayScreen(
    message: String = "Are you sure you want to exit?",
    onConfirm: () -> Unit = { println("OK") },
    onCancel: () -> Unit = {}
) {
        val colors = CustomThemeHelper.colors
        val sizeKit = rememberSizeKit()

    //FULL SCREEN OVERLAY disabled clicking off screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.overlayBg)
            .clickable(enabled = false) {} // block clicks to underlying content
    ) {
      //Smaller view for the content
        Surface(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.9f),
            color = colors.background,
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = message,
                    style = AppTypography.body,
                    color = colors.textPrimary
                )

                Spacer(modifier = Modifier.padding(sizeKit.spacingSmall))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    //ACCEPT
                    Button(
                        onClick = onConfirm,
                        colors = ButtonDefaults.buttonColors(backgroundColor = colors.iconAcceptBg),
                        shape = CircleShape
                    ) {
                        Text(text = "Yes", color = colors.textBlack)
                    }

                    //DECLINE
                    Button(
                        onClick = onCancel,
                        colors = ButtonDefaults.buttonColors(backgroundColor = colors.iconDeclineBg),
                        shape = CircleShape
                    ) {
                        Text(text = "No", color = colors.textBlack)
                    }
                }
            }
        }
    }
}
