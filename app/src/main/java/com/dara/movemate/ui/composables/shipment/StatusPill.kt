package com.dara.movemate.ui.composables.shipment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.movemate.R
import com.dara.movemate.data.ShipmentStatus
import com.dara.movemate.ui.theme.MovemateColors
import com.dara.movemate.ui.theme.blue_text
import com.dara.movemate.ui.theme.green_text
import com.dara.movemate.ui.theme.navy_blue
import com.dara.movemate.ui.theme.pale_grey
import com.dara.movemate.utils.mapStatus

@Composable
fun StatusPill(status: ShipmentStatus) {
    val color = when (status) {
        ShipmentStatus.Completed -> Green
        ShipmentStatus.InProgress -> green_text
        ShipmentStatus.Pending -> MovemateColors.secondary.copy(alpha = 0.8F)
        ShipmentStatus.Loading -> blue_text
        ShipmentStatus.WaitingToCollect -> Yellow
        ShipmentStatus.Cancelled -> Red
    }
    val icon = when (status) {
        ShipmentStatus.Completed -> R.drawable.ic_completed
        ShipmentStatus.InProgress -> R.drawable.in_progress
        ShipmentStatus.Pending -> R.drawable.ic_pending
        ShipmentStatus.Loading -> R.drawable.ic_loading
        ShipmentStatus.WaitingToCollect -> R.drawable.status_default
        ShipmentStatus.Cancelled -> R.drawable.ic_cancelled
    }
    Row(
        modifier = Modifier
            .background(
                color = pale_grey.copy(alpha = 0.4F),
                shape = CircleShape
            )
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = color
        )
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = status.mapStatus(),
            fontSize = 14.sp,
            color = color,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview
@Composable
fun StatusPillPreview() {
    StatusPill(ShipmentStatus.InProgress)
}
