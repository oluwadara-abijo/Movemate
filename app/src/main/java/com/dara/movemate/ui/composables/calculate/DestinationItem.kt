package com.dara.movemate.ui.composables.calculate

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.movemate.R
import com.dara.movemate.ui.theme.Dimens
import com.dara.movemate.ui.theme.MovemateColors
import com.dara.movemate.ui.theme.indicator_color
import com.dara.movemate.ui.theme.navy_blue

@Composable
fun DestinationItem(
    @DrawableRes iconId: Int,
    placeholder: String
) {
    var query by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Dimens.DefaultPadding),
        value = query,
        onValueChange = { query = it },
        placeholder = { Text(placeholder, color = Color.Gray) },
        leadingIcon = { LeadingIcon(iconId = iconId) },
        shape = RoundedCornerShape(16.dp),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedTextColor = navy_blue,
            unfocusedTextColor = navy_blue,
            focusedContainerColor = MovemateColors.background,
            unfocusedContainerColor = MovemateColors.background,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
    )
}

@Composable
fun LeadingIcon(@DrawableRes iconId: Int) {
    Row(
        modifier = Modifier
            .padding(start = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painterResource(id = iconId),
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
    }
}

@Preview
@Composable
fun DestinationItemPreview() {
    DestinationItem(
        R.drawable.outbox,
        "Sender location"
    )
}
