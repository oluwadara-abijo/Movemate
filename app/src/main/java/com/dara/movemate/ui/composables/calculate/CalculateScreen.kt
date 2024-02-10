package com.dara.movemate.ui.composables.calculate

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dara.movemate.ui.composables.Screen

@Composable
fun CalculateScreen(
    navigateBack: () -> Unit
) {
    Screen {
        LazyColumn {
            item { CalculateScreenAppBar(navigateBack) }
        }

    }
}

@Preview
@Composable
fun CalculateScreenPreview() {
    CalculateScreen() {}
}
