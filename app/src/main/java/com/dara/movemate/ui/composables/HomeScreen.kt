package com.dara.movemate.ui.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.dara.movemate.R

@Composable
fun HomeScreen() {
    Screen {
        Text(text = stringResource(id = R.string.home))
    }
}
