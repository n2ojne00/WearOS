package com.example.mykotlinwearos.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import com.example.mykotlinwearos.R
import com.example.mykotlinwearos.presentation.components.ViewScrollable
import com.example.mykotlinwearos.presentation.practiceData.stepData
import com.example.mykotlinwearos.presentation.screens.details.OverlayScreen
import com.example.mykotlinwearos.presentation.theme.AppTypography
import com.example.mykotlinwearos.presentation.theme.CustomThemeHelper
import com.example.mykotlinwearos.presentation.theme.responsive.rememberSizeKit
import com.example.mykotlinwearos.presentation.theme.responsive.rememberWearScreenConfig

@Composable
fun ThemeTestScreen(navController: NavController) {
    val colors = CustomThemeHelper.colors
    val sizeKit = rememberSizeKit()
    val screen = rememberWearScreenConfig()
    val steps = stepData

    var showOverlay by remember{ mutableStateOf(false) }

    ViewScrollable()
    {
        Column(
            modifier = Modifier
                //No use because scrollable view
                //.align(Alignment.TopCenter)
                .height(sizeKit.quarterScreen)
        ) {

            Text(
                textAlign = TextAlign.Justify,
                color = colors.textPrimary,
                style = AppTypography.body,
                text = stringResource(R.string.steps)
            )

            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = colors.iconSecondary),
                onClick = { showOverlay = true },
            ) {
                Text("Show Overlay")
            }

        }

        Column(
            modifier = Modifier
            //No use because scrollable view
                //.align(Alignment.BottomEnd)
                //.height(sizeKit.halfScreen)
                //.verticalScroll(rememberScrollState())
        ) {

            steps.forEach { item ->
                val goal = item.stepCount > 6000

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Week column - right-aligned
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 4.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Text(
                            text = item.week.toString(),
                            color = colors.textPrimary,
                            style = AppTypography.body
                        )
                    }

                    // Step count column - centered
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = item.stepCount.toString(),
                            color = colors.textPrimary,
                            style = AppTypography.body,
                            textAlign = TextAlign.Center
                        )
                    }

                    // Goal column - left-aligned
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 4.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (goal) {
                            //If goal is true (over 6000 steps) show icon
                            Icon(
                                imageVector = Icons.Default.Favorite,
                                contentDescription = "Goal reached",
                                tint = colors.textHighlight,
                                modifier = Modifier.size(20.dp)
                            )
                        } //If goal is not true (under 6000 steps)
                        else {
                            Text(
                                text = "",
                                style = AppTypography.body
                            )
                        }
                    }
                }
            }
        }


    }
    // Overlay
    if (showOverlay) {
        OverlayScreen(
            onCancel = { showOverlay = false },
            onConfirm = { println("OK"); showOverlay = false }
        )
    }
}
