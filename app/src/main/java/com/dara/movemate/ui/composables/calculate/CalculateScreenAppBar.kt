package com.dara.movemate.ui.composables.calculate

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dara.movemate.R
import com.dara.movemate.ui.composables.components.BackButton
import com.dara.movemate.ui.composables.components.LabelText
import com.dara.movemate.ui.theme.MovemateColors

@Composable
fun CalculateScreenAppBar(
    navigateBack: () -> Unit
) {
    var animateComponents by remember { mutableStateOf(false) }

    val height by animateDpAsState(
        targetValue = if (animateComponents) 60.dp else 180.dp,
        animationSpec = tween(durationMillis = 1000),
        label = "offset"
    )

    LaunchedEffect(Unit) {
        animateComponents = true
    }

    Row(
        modifier = Modifier
            .animateContentSize()
            .fillMaxWidth()
            .height(height)
            .background(MovemateColors.primary),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BackButton(animateComponents, navigateBack)
        LabelText(
            textId = R.string.calculate,
            textColor = White
        )
        Spacer(
            modifier = Modifier
                .size(50.dp)
        )
    }
}

@Preview
@Composable
fun CalculateScreenAppBarPreview() {
    CalculateScreenAppBar {}
}