package com.dara.movemate.ui.composables.calculate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dara.movemate.R

@Composable
fun DestinationCard() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        DestinationItem(iconId = R.drawable.outbox, placeholder = "Sender location")
        DestinationItem(iconId = R.drawable.inbox, placeholder = "Receiver location")
        DestinationItem(iconId = R.drawable.scale, placeholder = "Approx weight")
    }

}

@Preview
@Composable
fun DestinationCardPreview() {
    DestinationCard()
}