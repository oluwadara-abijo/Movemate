package com.dara.movemate.ui.composables.calculate

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dara.movemate.R
import com.dara.movemate.ui.theme.MovemateColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculateScreenAppBar(
    navigateBack: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = R.string.calculate)) },
        navigationIcon = {
            Icon(
                modifier = Modifier
                    .size(48.dp)
                    .clickable { navigateBack() },
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                tint = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MovemateColors.primary,
            titleContentColor = Color.White
        )
    )
}

@Preview
@Composable
fun CalculateScreenAppBarPreview() {
    CalculateScreenAppBar {}
}