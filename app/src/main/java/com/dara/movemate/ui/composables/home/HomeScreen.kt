package com.dara.movemate.ui.composables.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.dara.movemate.R
import com.dara.movemate.data.Shipment
import com.dara.movemate.data.ShipmentStatus
import com.dara.movemate.ui.composables.Screen
import com.dara.movemate.ui.theme.Dimens

@Composable
fun HomeScreen() {
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

    Screen {
        LazyColumn {
            item { HomeScreenAppBar() }
            item {
                Text(
                    modifier = Modifier.padding(Dimens.DefaultPadding),
                    text = stringResource(R.string.tracking),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            item { TrackingCard(currentShipment = currentShipment) }
        }

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
