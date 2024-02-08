package com.dara.movemate.ui.composables.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dara.movemate.R
import com.dara.movemate.ui.composables.Screen

@Composable
fun HomeScreen() {
    Screen {
        HomeScreenAppBar()
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
