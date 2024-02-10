package com.dara.movemate.ui.composables.calculate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dara.movemate.R
import com.dara.movemate.ui.composables.LabelText
import com.dara.movemate.ui.composables.SecondaryText
import com.dara.movemate.ui.theme.MovemateColors

@Composable
fun PackagingComponent() {
    Column(
        Modifier
            .padding(16.dp)) {
        LabelText(
            textId = R.string.packaging,
        )
        SecondaryText(
            textId = R.string.what_are_you_sending,
            modifier = Modifier.padding(top = 6.dp)
        )
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painterResource(id = R.drawable.packaging_box),
                contentDescription = null,
                tint = Color(0xFF8C8C8E)
            )
            Divider(
                color = Color.Gray.copy(alpha = 0.6F),
                modifier = Modifier
                    .height(24.dp)
                    .padding(horizontal = 8.dp)
                    .width(0.5.dp)
            )
            LabelText(textId = R.string.box, fontWeight = FontWeight.Normal)
            Spacer(modifier = Modifier.weight(1F))
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                tint = Color(0xFF8C8C8E)
            )
        }
    }
}

@Preview
@Composable
fun PackagingComponentPreview() {
    PackagingComponent()
}