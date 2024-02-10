package com.dara.movemate.ui.composables.calculate

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dara.movemate.R
import com.dara.movemate.ui.composables.LabelText
import com.dara.movemate.ui.composables.Screen
import com.dara.movemate.ui.theme.Dimens.DefaultPadding

@Composable
fun CalculateScreen(
    navigateBack: () -> Unit
) {
    Screen {
        LazyColumn {
            item { CalculateScreenAppBar(navigateBack) }
            item {
                LabelText(
                    textId = R.string.destination,
                    paddingValues = PaddingValues(top = 24.dp, start = DefaultPadding)
                )
            }
            item { DestinationCard() }
            item { PackagingComponent() }
            item { CategoriesComponent() }
        }
    }
}
