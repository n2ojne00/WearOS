package com.example.mykotlinwearos.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import com.example.mykotlinwearos.presentation.theme.CustomThemeHelper
import com.example.mykotlinwearos.presentation.theme.responsive.rememberSizeKit
import com.example.mykotlinwearos.presentation.theme.responsive.rememberWearScreenConfig

/*
* Reusable scrollable layout for scrollable views with responsive paddings
*
* Content alignment set default to Top Start
*
* Borders used for debugging.
*
* How to use
ViewScrollable()
    {
    * scrollable content
    }
* */
@Composable
fun ViewScrollable(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable ColumnScope.() -> Unit
) {
    val colors = CustomThemeHelper.colors
    val screen = rememberWearScreenConfig()

    Column(
        modifier = modifier
            .border(1.dp, Color.Red) //Outer border
            .fillMaxSize()
            .background(colors.background)
            .padding(
                start = screen.horizontalPadding,
                end = screen.horizontalPadding,
                top = screen.verticalPadding
            )
            .border(1.dp, Color.Magenta) //inner border
            .verticalScroll(rememberScrollState()),

        horizontalAlignment = contentAlignment,
        content = content
    )
}