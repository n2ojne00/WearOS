package com.example.mykotlinwearos.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.items
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.compose.ui.res.stringResource
import androidx.wear.compose.material.Text
import com.example.mykotlinwearos.R
import com.example.mykotlinwearos.presentation.components.IconButton
import com.example.mykotlinwearos.presentation.theme.AppIcons
import com.example.mykotlinwearos.presentation.theme.CustomThemeHelper


@Composable
fun MainScreen(navController: NavController) {

    val colors = CustomThemeHelper.colors

    val buttons = listOf(
        Triple("Theme test", "themeTest", AppIcons.Reset),
        Triple("today", "today", AppIcons.Active),
        Triple("Screen size", "configTest", AppIcons.Account)
    )


    val listState = rememberScalingLazyListState()

    ScalingLazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background),
        state = listState,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp) //add spacing between items

    ) {

        item {
            Text(text = stringResource(R.string.app_welcome), color = colors.textPrimary)
        }

        items(buttons) { (label, route, icon) ->
            IconButton(
                icon = icon,
                contentDescription = label,
                onClick = { if (route.isNotEmpty()) navController.navigate(route) }
            )
        }
        item {
            Text(text = stringResource(R.string.exit), color = colors.textPrimary)
        }
        item {
            Text(text = stringResource(R.string.hello_name, "NAME" ), color = colors.textPrimary)
        }

 }


}

