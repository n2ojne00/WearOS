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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import com.example.mykotlinwearos.presentation.theme.AppTypography
import com.example.mykotlinwearos.presentation.theme.CustomThemeHelper
import com.example.mykotlinwearos.presentation.theme.responsive.rememberSizeKit

@Composable
fun OverlayScreen(
    message: String,
    modifier: Modifier = Modifier,
    icon: (@Composable (() -> Unit))? = null, // optional icon
    primaryButtonText: String = "OK",
    secondaryButtonText: String? = null, // optional secondary button
    onPrimaryClick: () -> Unit = {},
    onSecondaryClick: (() -> Unit)? = null
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
                modifier = Modifier
                    .height(sizeKit.halfScreen),
                //modifier = Modifier.padding(sizeKit.spacingMedium)
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

            ) {
                // Optional icon
                if (icon != null) {
                    icon()
                    Spacer(modifier = Modifier.height(sizeKit.spacingSmall))
                }

                // Message text
                Text(
                    text = message,
                    style = AppTypography.body,
                    color = colors.textPrimary,
                    textAlign = TextAlign.Center
                )


                Spacer(modifier = Modifier.padding(sizeKit.spacingSmall))

                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Primary button (always shown)
                    Button(
                        onClick = onPrimaryClick,
                        colors = ButtonDefaults.buttonColors(backgroundColor = colors.iconAcceptBg),
                        shape = CircleShape
                    ) {
                        Text(primaryButtonText, color = colors.textBlack)
                    }

                    // Secondary button (only if provided)
                    if (secondaryButtonText != null && onSecondaryClick != null) {
                        Button(
                            onClick = onSecondaryClick,
                            colors = ButtonDefaults.buttonColors(backgroundColor = colors.iconDeclineBg),
                            shape = CircleShape
                        ) {
                            Text(secondaryButtonText, color = colors.textBlack)
                        }
                    }
                }
            }
        }
    }
}
