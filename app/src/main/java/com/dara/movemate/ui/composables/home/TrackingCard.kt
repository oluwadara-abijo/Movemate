package com.dara.movemate.ui.composables.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.movemate.R
import com.dara.movemate.data.Shipment
import com.dara.movemate.ui.composables.MovemateDivider
import com.dara.movemate.ui.theme.Dimens.DefaultPadding
import com.dara.movemate.ui.theme.Dimens.PaddingHalf
import com.dara.movemate.ui.theme.Dimens.PaddingQuarter
import com.dara.movemate.ui.theme.Dimens.ProfilePictureSize
import com.dara.movemate.ui.theme.indicator_color
import com.dara.movemate.ui.theme.light_orange
import com.dara.movemate.ui.theme.receiver_box_background
import com.dara.movemate.ui.theme.sender_box_background
import com.dara.movemate.utils.mapStatus

@Composable
fun TrackingCard(
    currentShipment: Shipment
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(DefaultPadding)
            .background(
                color = White,
                shape = RoundedCornerShape(DefaultPadding)
            )
            .padding(vertical = 24.dp)
            .clip(RoundedCornerShape(DefaultPadding)),
    ) {
        Row(modifier = Modifier.padding(horizontal = DefaultPadding)) {
            Column {
                Text(
                    text = stringResource(R.string.shipment_number),
                    color = Color.Gray,
                    fontSize = 16.sp
                )
                Text(
                    modifier = Modifier.padding(top = PaddingQuarter),
                    text = currentShipment.id,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.weight(1F))
            Image(
                painter = painterResource(id = R.drawable.truck),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(ProfilePictureSize)
            )
        }
        MovemateDivider(horizontalPadding = DefaultPadding)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = DefaultPadding),
            verticalAlignment = Bottom,
            horizontalArrangement = SpaceBetween
        ) {
            Column {
                ShipmentInfoWidget(
                    title = stringResource(R.string.sender),
                    description = currentShipment.sender,
                    icon = R.drawable.box,
                    backgroundColor = sender_box_background
                )
                Spacer(modifier = Modifier.height(32.dp))
                ShipmentInfoWidget(
                    title = stringResource(R.string.receiver),
                    description = currentShipment.receiver,
                    icon = R.drawable.box,
                    backgroundColor = receiver_box_background
                )
            }
            Spacer(modifier = Modifier.width(32.dp))
            Column(
                verticalArrangement = Arrangement.SpaceAround
            ) {
                ShipmentInfoWidget(
                    title = stringResource(R.string.time),
                    description = currentShipment.timeline,
                    showIcon = false,
                    showIndicator = true
                )
                Spacer(modifier = Modifier.height(32.dp))
                ShipmentInfoWidget(
                    title = stringResource(R.string.status),
                    description = currentShipment.status.mapStatus(),
                    showIcon = false
                )
            }
        }
        MovemateDivider()
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                tint = light_orange
            )
            Text(
                text = "Add Stop",
                color = light_orange,
                fontSize = 18.sp
            )
        }

    }
}

@Composable
fun ShipmentInfoWidget(
    title: String,
    description: String,
    icon: Int = 0,
    backgroundColor: Color = White,
    showIcon: Boolean = true,
    showIndicator: Boolean = false
) {
    Row {
        if (showIcon) {
            Image(
                modifier = Modifier
                    .background(color = backgroundColor, shape = CircleShape)
                    .size(48.dp)
                    .padding(PaddingQuarter),
                painter = painterResource(id = icon),
                contentDescription = null,
            )
        }
        Column(
            modifier = Modifier.padding(start = PaddingHalf),
        ) {
            Text(
                text = title,
                color = Color.Gray,
                fontSize = 16.sp
            )
            Row(verticalAlignment = CenterVertically) {
                if (showIndicator) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_circle),
                        contentDescription = null,
                        modifier = Modifier
                            .size(DefaultPadding)
                            .padding(end = PaddingQuarter),
                        tint = indicator_color
                    )
                }
                Text(
                    text = description,
                    fontSize = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }

}
