package com.example.mykotlinwearos.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mykotlinwearos.presentation.theme.CustomThemeHelper
import com.example.mykotlinwearos.presentation.theme.responsive.rememberSizeKit
import com.example.mykotlinwearos.presentation.theme.responsive.rememberWearScreenConfig

/*
* Reusable static layout for non scrollable views with responsive paddings
*
* Content alignment set default to Top Start
*
* Borders used for debugging.
*
* How to use

ViewStatic() {
    }

* */
@Composable
fun ViewStatic(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    content: @Composable BoxScope.() -> Unit
) {

    val colors = CustomThemeHelper.colors
    val sizeKit = rememberSizeKit()
    val screen = rememberWearScreenConfig()

    val baseModifier = Modifier
        .border(1.dp, Color.Red) //Outer border
        .background(colors.background)
        .fillMaxSize()
        .padding(
            horizontal = screen.horizontalPadding,
            vertical = screen.verticalPadding
        )
        .border(1.dp, Color.Blue) //inner border


        /* click enabling?
          blockClicks: Boolean = true,

        .then(

            if (blockClicks) Modifier.clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                enabled = true
            ) { /* consume clicks but do nothing */ }
            else Modifier
        )*/

    Box(
        modifier = baseModifier.then(modifier),
        contentAlignment = contentAlignment
    ) {
    content()
    }
}