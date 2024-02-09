package com.dara.movemate.ui.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun LabelText(
    @StringRes textId: Int,
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues
) {
    Text(
        modifier = modifier.padding(paddingValues),
        text = stringResource(textId),
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    )
}
