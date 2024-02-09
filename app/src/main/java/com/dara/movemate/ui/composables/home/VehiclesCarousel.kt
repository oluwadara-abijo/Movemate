package com.dara.movemate.ui.composables.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dara.movemate.data.Vehicle
import com.dara.movemate.ui.theme.Dimens.DefaultPadding

@Composable
fun VehiclesCarousel(vehicles: List<Vehicle>) {
    Row(modifier = Modifier
        .padding(top = DefaultPadding)
        .horizontalScroll(rememberScrollState())) {
        vehicles.forEach { vehicle -> VehicleCard(vehicle) }
    }
}
