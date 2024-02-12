package com.dara.movemate.ui.composables.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.dara.movemate.R
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

    Screen {
        LazyColumn {
            item {
                HomeScreenAppBar(
                    isSearching = isSearching,
                    onToggleSearch = { isSearching = !isSearching }
                )
            }
            if (isSearching) {
                item { Text(text = "Search content") }
            } else {
                item {
                    LabelText(
                        textId = R.string.tracking,
                        paddingValues = PaddingValues(top = 24.dp, start = Dimens.DefaultPadding)
                    )
                }
                item { TrackingCard(currentShipment = currentShipment) }
                item {
                    LabelText(
                        textId = R.string.available_vehicles,
                        paddingValues = PaddingValues(top = 24.dp, start = Dimens.DefaultPadding)
                    )
                }
                item { VehiclesCarousel(vehicles = availableVehicles) }
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
