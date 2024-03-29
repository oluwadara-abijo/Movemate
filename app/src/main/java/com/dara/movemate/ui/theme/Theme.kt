package com.dara.movemate.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MovemateTheme(
    content: @Composable () -> Unit,
) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.run {
            setStatusBarColor(
                color = MovemateColors.primary,
            )
            setNavigationBarColor(
                color = MovemateColors.background,
            )
        }
    }

    MaterialTheme(
        colorScheme = MovemateColors,
        content = content,
        typography = Typography,
    )
}
