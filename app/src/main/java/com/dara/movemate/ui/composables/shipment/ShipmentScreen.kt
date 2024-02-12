package com.dara.movemate.ui.composables.shipment

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dara.movemate.R
import com.dara.movemate.data.Shipment
import com.dara.movemate.data.ShipmentStatus.Cancelled
import com.dara.movemate.data.ShipmentStatus.Completed
import com.dara.movemate.data.ShipmentStatus.InProgress
import com.dara.movemate.data.ShipmentStatus.Loading
import com.dara.movemate.data.ShipmentStatus.Pending
import com.dara.movemate.ui.composables.Screen
import com.dara.movemate.ui.composables.components.LabelText

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShipmentScreen(
    navigateBack: () -> Unit,
) {
    var allShipments by remember { mutableStateOf(shipments) }

    Screen {
        Column {
            ShipmentScreenAppBar(
                navigateBack = navigateBack,
                filterShipments = { status ->
                    allShipments = if (status != null) {
                        shipments.filter { it.status == status }
                    } else {
                        shipments
                    }
                },
            )
            LazyColumn(
            ) {
                item {
                    LabelText(
                        textId = R.string.shipments,
                        paddingValues = PaddingValues(top = 16.dp, start = 24.dp)
                    )
                }
                items(allShipments, key = { it.id }) { shipment ->
                    ShipmentCard(
                        shipment = shipment,
                        modifier = Modifier.animateItemPlacement(
                            tween(delayMillis = 500, easing = FastOutSlowInEasing)
                          )
                    )
                }
            }
        }
    }
}

val shipments = listOf(
    Shipment(
        id = "NEJ200899341222310",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = InProgress,
        amount = "$1400 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222311",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = Pending,
        amount = "$650 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222312",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = Pending,
        amount = "$650 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222313",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = Loading,
        amount = "$230 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222314",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = Loading,
        amount = "$230 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222315",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = InProgress,
        amount = "$370 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222316",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = Pending,
        amount = "$370 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222317",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = InProgress,
        amount = "$3570 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222318",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = Cancelled,
        amount = "$370 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ200899341222319",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = Pending,
        amount = "$370 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
    Shipment(
        id = "NEJ2008993412223110",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = Completed,
        amount = "$370 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    ),
)
