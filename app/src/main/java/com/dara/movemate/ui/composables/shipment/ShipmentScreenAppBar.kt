package com.dara.movemate.ui.composables.shipment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dara.movemate.R
import com.dara.movemate.data.ShipmentStatus
import com.dara.movemate.ui.composables.components.LabelText
import com.dara.movemate.ui.theme.MovemateColors

@Composable
fun ShipmentScreenAppBar(
    navigateBack: () -> Unit,
    filterShipments: (ShipmentStatus?) -> Unit
) {
    Column(
        modifier = Modifier
            .background(MovemateColors.primary)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                modifier = Modifier
                    .size(48.dp)
                    .clickable { navigateBack() },
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                tint = Color.White
            )
            LabelText(
                textId = R.string.shipment_history, textColor = Color.White
            )
            Spacer(Modifier.size(48.dp))
        }
        ShipmentTabRow(filterShipments = filterShipments)
    }
}

@Composable
fun ShipmentTabRow(
    filterShipments: (ShipmentStatus?) -> Unit
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("All", "Completed", "In progress", "Pending order", "Cancelled")
    val currentFilter = when (selectedTabIndex) {
        1 -> ShipmentStatus.Completed
        2 -> ShipmentStatus.InProgress
        3 -> ShipmentStatus.Pending
        4 -> ShipmentStatus.Cancelled
        else -> null
    }
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        containerColor = MovemateColors.primary,
        contentColor = Color.White,
        edgePadding = 0.dp,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                color = MovemateColors.secondary
            )
        }
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    filterShipments(currentFilter)
                },
                text = { Text(text = tab) }
            )
        }
    }
}

@Preview
@Composable
fun ShipmentScreenAppBarPreview() {
    ShipmentScreenAppBar(navigateBack = {}, filterShipments = {})
}
