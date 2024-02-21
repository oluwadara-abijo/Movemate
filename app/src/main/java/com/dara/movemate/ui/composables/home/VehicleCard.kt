package com.dara.movemate.ui.composables.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.movemate.R
import com.dara.movemate.data.Vehicle
import com.dara.movemate.ui.theme.Dimens.DefaultPadding

@Composable
fun VehicleCard(vehicle: Vehicle) {
    var animateComponents by remember { mutableStateOf(false) }

    SideEffect {
        animateComponents = true
    }
    Column(
        modifier = Modifier
            .size(height = 230.dp, width = 210.dp)
            .padding(start = DefaultPadding)
            .background(
                color = White,
                shape = RoundedCornerShape(DefaultPadding)
            )
            .padding(top = 24.dp, start = 24.dp)
            .clipToBounds()
    ) {
        Text(
            text = vehicle.freight,
            fontSize = 22.sp,
        )
        Text(
            text = vehicle.category,
            color = Gray,
            fontSize = 16.sp
        )
        AnimatedVisibility(
            visible = animateComponents,
            enter = slideInHorizontally(
                initialOffsetX = { 300 },
                animationSpec = tween(durationMillis = 1000)
            ) + fadeIn()
        ) {
            Image(
                painter = painterResource(vehicle.icon),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .scale(1.3F)
                    .offset(x = 48.dp, y = -(16).dp)
            )
        }
    }
}

@Preview
@Composable
fun VehicleCardPreview() {
    Box(
        modifier = Modifier
            .background(Gray)
            .fillMaxSize()
    ) {
        VehicleCard(Vehicle("Ocean freight", "International", R.drawable.ship))
    }
}
