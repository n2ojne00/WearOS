package com.example.mykotlinwearos.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import com.example.mykotlinwearos.presentation.theme.CustomThemeHelper
import com.example.mykotlinwearos.presentation.theme.responsive.rememberSizeKit
import com.example.mykotlinwearos.presentation.theme.responsive.rememberWearScreenConfig


/**
 * Re usable icon button, icon added on function
 *
 *
 IconButton(
 onClick = { /* do sth */ },
iconSlot = {
 Icon(
 imageVector = Icons.Default.Favorite,
contentDescription = "favorite",
 modifier = Modifier.size(12.dp)
 )
 }
   )
 */
@Composable
fun IconButton(
    icon: ImageVector,
    contentDescription: String? = null,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    val colors = CustomThemeHelper.colors
    val screen = rememberWearScreenConfig()
    val sizeKit = rememberSizeKit()

    // Scale button + icon size relative to screen width
    val buttonSize = screen.screenWidth * 0.60f  // 60% of screen width
    val iconSize = buttonSize * 0.6f           // icon size inside button 60% of it

    Button(
        onClick = onClick,
        modifier = modifier.size(sizeKit.navButtonSize),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colors.buttonMain,
            contentColor = colors.textBlack
        ),
        shape = CircleShape
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier.size(sizeKit.navIconSize)
        )
    }
}