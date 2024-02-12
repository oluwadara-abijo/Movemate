package com.dara.movemate.ui.composables.calculate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.movemate.R
import com.dara.movemate.ui.composables.Screen
import com.dara.movemate.ui.composables.components.ActionButton
import com.dara.movemate.ui.composables.components.SecondaryText
import com.dara.movemate.ui.theme.MovemateColors
import com.dara.movemate.ui.theme.green_text

@Composable
fun EstimateScreen() {
    Screen {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "MoveMate",
                    color = MovemateColors.primary,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )
                Icon(
                    modifier = Modifier
                        .size(48.dp)
                        .padding(start = 8.dp, bottom = 2.dp),
                    painter = painterResource(id = R.drawable.logo_truck),
                    contentDescription = null,
                    tint = MovemateColors.secondary
                )
            }
            Icon(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.movemate_box),
                contentDescription = null,
                tint = MovemateColors.outline
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(R.string.total_estimated_amount),
                    fontSize = 26.sp
                )
                Text(
                    text = "$1460 USD",
                    fontSize = 26.sp,
                    color = green_text
                )
                SecondaryText(
                    text = stringResource(id = R.string.estimate_description),
                    paddingValues = PaddingValues(top = 8.dp),
                    alignment = TextAlign.Center
                )
            }
            ActionButton(onButtonClick = { }, label = R.string.back_to_home, labelFontSize = 14.sp)
        }
    }
}
