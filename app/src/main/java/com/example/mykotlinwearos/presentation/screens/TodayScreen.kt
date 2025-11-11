package com.example.mykotlinwearos.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mykotlinwearos.R
import com.example.mykotlinwearos.presentation.components.ViewStatic
import com.example.mykotlinwearos.presentation.components.setDate
import com.example.mykotlinwearos.presentation.theme.AppIcons
import com.example.mykotlinwearos.presentation.theme.AppTypography
import com.example.mykotlinwearos.presentation.theme.CustomThemeHelper
import com.example.mykotlinwearos.presentation.theme.responsive.rememberSizeKit
import com.example.mykotlinwearos.presentation.theme.responsive.rememberWearScreenConfig

@Composable
fun TodayScreen(navController: NavController) {
    val colors = CustomThemeHelper.colors
    val screen = rememberWearScreenConfig()
    val sizeKit = rememberSizeKit()

    ViewStatic(
        contentAlignment = Alignment.Center
    ) {
        //HEADER
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            //TODAY
            setDate()
            /*
              Text(
                text = stringResource(R.string.today),
                style = AppTypography.header,
                color = colors.textPrimary
            )
            */

            Spacer(modifier = Modifier.padding(sizeKit.spacingSmall))

            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Icon(
                    imageVector = AppIcons.Favorite,
                    contentDescription = stringResource(R.string.heart_rate_now),
                    tint = colors.iconError,
                    modifier = Modifier
                        .size(sizeKit.iconMedium)
                )

                Text(
                    text = stringResource(R.string.example_number_1),
                    style = AppTypography.title,
                    color = colors.textPrimary,
                )
            }
            Spacer(modifier = Modifier.padding(sizeKit.spacingSmall))

            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Icon(
                    imageVector = AppIcons.Info,
                    contentDescription = stringResource(R.string.sleep),
                    tint = colors.textHighlight,
                    modifier = Modifier
                        .size(sizeKit.iconMedium)
                )

                Text(
                    text = stringResource(R.string.time_hours_minutes, "8", "34"),
                    style = AppTypography.title,
                    color = colors.textPrimary,

                )
            }

            Spacer(modifier = Modifier.padding(sizeKit.spacingSmall))

            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Icon(
                    imageVector = AppIcons.Person,
                    contentDescription = stringResource(R.string.steps),
                    tint = colors.textSuccess,
                    modifier = Modifier
                        .size(sizeKit.iconMedium)

                )

                Text(
                    text = stringResource(R.string.example_number_3),
                    style = AppTypography.title,
                    color = colors.textPrimary,

                )
                Text(
                    text = stringResource(R.string.slash),
                    style = AppTypography.header,
                    color = colors.textPrimary,
                )

                Text(
                    text = stringResource(R.string.example_number_goal),
                    style = AppTypography.title,
                    color = colors.textHighlightOff,
                    )
            }

        }
    }
}
