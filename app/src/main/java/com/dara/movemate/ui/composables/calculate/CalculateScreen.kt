package com.dara.movemate.ui.composables.calculate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.movemate.R
import com.dara.movemate.ui.composables.Screen
import com.dara.movemate.ui.composables.components.ActionButton
import com.dara.movemate.ui.composables.components.LabelText

@Composable
fun CalculateScreen(
    navigateBack: () -> Unit,
    onCalculateClicked: () -> Unit,
) {
    Screen {
        Column {
            CalculateScreenAppBar(navigateBack)
            LazyColumn(
                contentPadding = PaddingValues(vertical = 24.dp, horizontal = 24.dp),
            ) {
                item {
                    LabelText(
                        textId = R.string.destination,
                    )
                }
                item { DestinationCard() }
                item { PackagingComponent() }
                item { CategoriesComponent() }
                item {
                    ActionButton(
                        onButtonClick = onCalculateClicked,
                        label = R.string.calculate,
                        paddingValues = PaddingValues(top = 48.dp),
                        labelFontSize = 22.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CalculateScreenPreview() {
    CalculateScreen(navigateBack = {}) {

    }
}
