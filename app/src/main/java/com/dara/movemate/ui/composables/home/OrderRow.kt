package com.dara.movemate.ui.composables.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.movemate.R
import com.dara.movemate.data.Order
import com.dara.movemate.ui.composables.components.SecondaryText
import com.dara.movemate.ui.theme.MovemateColors

@Composable
fun OrderRow(order: Order) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .background(MovemateColors.primary, CircleShape)
                .size(32.dp)
                .padding(4.dp),
            painter = painterResource(id = R.drawable.packaging_box),
            contentDescription = null,
            tint = Color.White
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = order.name,
                fontWeight = SemiBold
            )
            Row(verticalAlignment = CenterVertically) {
                SecondaryText(
                    text = order.id,
                    fontSize = 14.sp
                )
                SecondaryText(
                    text = "•",
                    fontSize = 14.sp,
                    paddingValues = PaddingValues(horizontal = 4.dp)
                )
                SecondaryText(text = order.sender, fontSize = 12.sp)
                Icon(
                    modifier = Modifier
                        .size(18.dp)
                        .padding(horizontal = 2.dp),
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = Color.Gray
                )
                SecondaryText(
                    text = order.receiver,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun OrderRowPreview() {
    OrderRow(
        Order(
            id = "#NE43857340857904",
            name = "Macbook pro M2",
            sender = "Paris",
            receiver = "Morocco"
        )
    )
}