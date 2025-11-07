package com.example.mykotlinwearos.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mykotlinwearos.R
import com.example.mykotlinwearos.presentation.theme.CustomThemeHelper
import com.example.mykotlinwearos.presentation.theme.responsive.rememberSizeKit

@Composable
fun ThemeTestScreen(navController: NavController) {
    val colors = CustomThemeHelper.colors
    val sizeKit = rememberSizeKit()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = stringResource(R.string.practice), color = colors.textPrimary)
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = { /* TO DO */ },
                modifier = Modifier.size(sizeKit.buttonMedium),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colors.buttonMain
                ),
                shape = CircleShape
            ) {
                Text(text = stringResource(R.string.exit), color = colors.textBlack)
            }
            Button(
                onClick = { /* TO DO */ },
                modifier = Modifier.size(sizeKit.buttonSmall),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colors.buttonMain
                ),
                shape = CircleShape
            ) {
                Text(text = stringResource(R.string.exit), color = colors.textBlack)
            }
        }
    }
}
