package com.dara.movemate.ui.composables.shipment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dara.movemate.R
import com.dara.movemate.data.Shipment
import com.dara.movemate.data.ShipmentStatus
import com.dara.movemate.ui.composables.Screen
import com.dara.movemate.ui.composables.components.LabelText

@Composable
fun ShipmentScreen(
    navigateBack: () -> Unit,
) {
    Screen {
        Column {
            ShipmentScreenAppBar(
                navigateBack = navigateBack,
                filterShipments = { status -> shipments.filter { it.status == status } }
            )
            LazyColumn(
            ) {
                item {
                    LabelText(
                        textId = R.string.shipments,
                        paddingValues = PaddingValues(top = 16.dp, start = 24.dp)
                    )
                }
                items(shipments) { shipment ->
                    ShipmentCard(shipment)
                }
            }
        }
    }
}

val shipments = listOf(
    Shipment(
        id = "NEJ20089934122231",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.InProgress,
        amount = "$1400 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ20089934122231",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.Pending,
        amount = "$650 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ20089934122231",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.Pending,
        amount = "$650 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ20089934122231",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.Loading,
        amount = "$230 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ20089934122231",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.Loading,
        amount = "$230 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ20089934122231",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.InProgress,
        amount = "$370 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ20089934122231",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.Pending,
        amount = "$370 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
)
