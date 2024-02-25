package com.dara.movemate.ui.composables.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dara.movemate.R
import com.dara.movemate.data.Vehicle
import com.dara.movemate.ui.composables.components.LabelText
import com.dara.movemate.ui.theme.Dimens
import com.dara.movemate.ui.theme.Dimens.DefaultPadding
import com.dara.movemate.ui.theme.Dimens.tweenAnimationDuration

@Composable
fun VehiclesCarousel(vehicles: List<Vehicle>) {
    var animateComponents by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        animateComponents = true
    }

    AnimatedVisibility(
        visible = animateComponents,
        enter = slideInVertically(
            animationSpec = tween(tweenAnimationDuration),
            initialOffsetY = { fullHeight -> fullHeight * 2 }) + fadeIn(animationSpec = tween(
            tweenAnimationDuration
        )),
    ) {
        Column {
            LabelText(
                textId = R.string.available_vehicles,
                paddingValues = PaddingValues(
                    top = 24.dp,
                    start = DefaultPadding
                )
            )
            Row(
                modifier = Modifier
                    .padding(top = DefaultPadding)
                    .horizontalScroll(rememberScrollState())
            ) {
                vehicles.forEach { vehicle -> VehicleCard(vehicle) }
            }
        }
    }
}
