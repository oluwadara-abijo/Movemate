package com.dara.movemate.ui.composables.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dara.movemate.ui.theme.navy_blue

@Composable
fun LabelText(
    @StringRes textId: Int,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(),
    fontWeight: FontWeight = FontWeight.Bold
) {
    Text(
        modifier = modifier.padding(paddingValues),
        text = stringResource(textId),
        fontSize = 22.sp,
        fontWeight = fontWeight,
        color = navy_blue
    )
}

@Composable
fun SecondaryText(
    @StringRes textId: Int,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues()
) {
    Text(
        modifier = modifier.padding(paddingValues),
        text = stringResource(textId),
        color = Color.Gray,
        fontSize = 16.sp
    )
}
