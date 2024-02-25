package com.dara.movemate.ui.composables.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dara.movemate.ui.theme.Dimens
import com.dara.movemate.ui.theme.Dimens.tweenAnimationDuration

@Composable
fun BackButton(
    animateComponents: Boolean,
    navigateBack: () -> Unit
) {
    AnimatedVisibility(
        visible = animateComponents,
        enter = expandHorizontally() + fadeIn(animationSpec = tween(tweenAnimationDuration)),
        exit = fadeOut()
    ) {
        Icon(
            modifier = Modifier
                .padding(start = 12.dp)
                .size(48.dp)
                .clickable { navigateBack() },
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = null,
            tint = Color.White
        )
    }
}
