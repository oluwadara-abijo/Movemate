package com.dara.movemate.ui.composables.shipment

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.dara.movemate.ui.composables.Screen

@Composable
fun ShipmentScreen(
    navigateBack: () -> Unit
) {
    Screen {
        Column {
            ShipmentScreenAppBar(
                navigateBack = navigateBack,
                filterShipments = { status -> }
            )
        }
    }
}
