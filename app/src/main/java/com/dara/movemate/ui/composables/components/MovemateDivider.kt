package com.dara.movemate.ui.composables.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dara.movemate.ui.theme.Dimens

@Composable
fun MovemateDivider(horizontalPadding: Dp = 0.dp) {
    Divider(
        modifier = Modifier.padding(
            vertical = Dimens.DefaultPadding,
            horizontal = horizontalPadding
        ),
        color = Color.Gray.copy(alpha = 0.2F)
    )
}
