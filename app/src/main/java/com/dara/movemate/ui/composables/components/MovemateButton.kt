package com.dara.movemate.ui.composables.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.movemate.R
import com.dara.movemate.ui.theme.MovemateColors

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
    @StringRes label: Int,
    paddingValues: PaddingValues = PaddingValues(),
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(paddingValues),
        onClick = onButtonClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MovemateColors.secondary
        ),
        contentPadding = PaddingValues(20.dp)
    ) {
        Text(
            text = stringResource(id = label),
            fontSize = 24.sp
        )
    }
}

@Preview
@Composable
fun ActionButtonPreview() {
    ActionButton(onButtonClick = { }, label = R.string.calculate)
}