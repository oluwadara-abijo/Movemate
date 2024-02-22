package com.dara.movemate.ui.composables.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dara.movemate.R
import com.dara.movemate.data.Order
import com.dara.movemate.data.Shipment
import com.dara.movemate.data.ShipmentStatus
import com.dara.movemate.data.Vehicle
import com.dara.movemate.ui.composables.Screen
import com.dara.movemate.ui.composables.components.LabelText
import com.dara.movemate.ui.theme.Dimens

@Composable
fun HomeScreen(
) {
    var isSearching by remember { mutableStateOf(false) }
    var allOrders by remember { mutableStateOf(orders) }

    Screen {
        Column {
            HomeScreenAppBar(
                isSearching = isSearching,
                onToggleSearch = { isSearching = !isSearching },
                onSearchOrder = { searchQuery ->
                    allOrders = orders.filter { it.id.contains(searchQuery) }
                }
            )
            if (isSearching) {
                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(16.dp)
                        )
                ) {
                    itemsIndexed(allOrders) { index, order ->
                        OrderRow(order = order)
                        if (index < allOrders.lastIndex) {
                            Divider(modifier = Modifier.padding(horizontal = 12.dp))
                        }
                    }
                }
            } else {
                LazyColumn {
                    item {

                    }
                    item { TrackingCard(currentShipment = currentShipment) }
                    item { VehiclesCarousel(vehicles = availableVehicles) }
                }
            }
        }
    }
}

val currentShipment = Shipment(
    id = "NEJ20089934122231",
    name = "iPhone 15 Pro",
    sender = "Atlanta, 5243",
    receiver = "Chicago, 6342",
    status = ShipmentStatus.WaitingToCollect,
    amount = "$1200.00",
    date = "8th Feb, 2024",
    timeline = "2 - 3 days"
)

val availableVehicles = listOf(
    Vehicle("Ocean freight", "International", R.drawable.ship),
    Vehicle("Cargo freight", "Reliable", R.drawable.cargo_truck),
    Vehicle("Air freight", "International", R.drawable.airplane)
)

val orders = listOf(
    Order(
        id = "#NE43857340857904",
        name = "Macbook pro M2",
        sender = "Paris",
        receiver = "Morocco"
    ),
    Order(
        id = "#NEJ20089934122231",
        name = "Summer linen jacket",
        sender = "Barcelona",
        receiver = "Paris"
    ),
    Order(
        id = "#NEJ35870264978659",
        name = "Tapered-fit jeans AW",
        sender = "Columbia",
        receiver = "Paris"
    ),
    Order(
        id = "#NEJ35870264978659",
        name = "Slim fit jeans AW",
        sender = "Bogota",
        receiver = "Dhaka"
    ),
    Order(
        id = "#NEJ23481570754963",
        name = "Office setup desk",
        sender = "France",
        receiver = "Germany"
    )
)
