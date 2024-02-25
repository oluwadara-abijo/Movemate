package com.dara.movemate.ui.composables.shipment

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.movemate.R
import com.dara.movemate.data.Shipment
import com.dara.movemate.data.ShipmentStatus
import com.dara.movemate.ui.theme.Dimens.tweenAnimationDuration
import com.dara.movemate.ui.theme.MovemateColors
import com.dara.movemate.ui.theme.pale_grey

@Composable
fun ShipmentCard(shipment: Shipment) {
    var animateComponents by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        animateComponents = true
    }

    AnimatedVisibility(
        visible = animateComponents,
        enter = slideInVertically(
            animationSpec = tween(tweenAnimationDuration),
            initialOffsetY = { fullHeight -> fullHeight * 2 })
    ) {
        Row(
            modifier = Modifier
                .padding(top = 12.dp, start = 16.dp, end = 16.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(2F)) {
                StatusPill(status = shipment.status)
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = stringResource(id = R.string.arriving_today),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = stringResource(
                        id = R.string.delivery_info,
                        shipment.id,
                        shipment.sender
                    ),
                    fontSize = 12.sp,
                    color = Color.Gray,
                    lineHeight = 16.sp
                )
                Row(
                    modifier = Modifier.padding(top = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = shipment.amount,
                        color = MovemateColors.primary,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = "•",
                        fontSize = 18.sp,
                        color = pale_grey,
                    )
                    Text(
                        text = shipment.date,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
            Icon(
                modifier = Modifier
                    .size(50.dp)
                    .weight(1F),
                painter = painterResource(id = R.drawable.movemate_box),
                contentDescription = null,
                tint = MovemateColors.outline,
            )
        }
    }
}

@Preview
@Composable
fun ShipmentCardPreview() {
    val shipment = Shipment(
        id = "NEJ20089934122231",
        name = "iPhone 15 Pro",
        sender = "Atlanta",
        receiver = "Chicago",
        status = ShipmentStatus.InProgress,
        amount = "$1400 USD",
        date = "Sep 20, 2023",
        timeline = "2 - 3 days"
    )
    ShipmentCard(shipment = shipment)
}
