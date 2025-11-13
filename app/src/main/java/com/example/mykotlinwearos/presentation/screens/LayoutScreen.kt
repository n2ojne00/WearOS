import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.material.*
import com.example.mykotlinwearos.presentation.components.ViewScrollable
import com.example.mykotlinwearos.presentation.deviceCapability.CapabilityChecker
import com.example.mykotlinwearos.presentation.theme.responsive.rememberWearScreenConfig


// WHAT SCREEN IS TEST

@Composable
fun SimpleConfigTest(navController: NavController) {
    val config = rememberWearScreenConfig()


    ViewScrollable(
    ) {
        Text(
            text = "SCREEN INFO",
            color = Color.Yellow,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Shape: ${if (config.isRound) "ROUND" else "SQUARE"}",
            color = Color.White,
            fontSize = 14.sp
        )

        Text(
            text = "Size: ${if (config.isSmall) "SMALL" else "NORMAL"}",
            color = Color.White,
            fontSize = 14.sp
        )

        Text(
            text = "${config.screenWidth.value.toInt()} x ${config.screenHeight.value.toInt()} dp",
            color = Color.White,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "H-Pad: ${config.horizontalPadding.value.toInt()}dp",
            color = Color.Cyan,
            fontSize = 12.sp
        )

        Text(
            text = "V-Pad: ${config.verticalPadding.value.toInt()}dp",
            color = Color.Cyan,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            CapabilityChecker()
        }
    }
}