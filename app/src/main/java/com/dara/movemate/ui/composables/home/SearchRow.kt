package com.dara.movemate.ui.composables.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dara.movemate.R
import com.dara.movemate.ui.theme.Dimens.DefaultPadding
import com.dara.movemate.ui.theme.MovemateColors

@Composable
fun SearchRow(
    toggleSearch: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = DefaultPadding)
            .onFocusChanged {
                if (it.isFocused) {
                    toggleSearch()
                }
            },
        value = searchQuery,
        onValueChange = { searchQuery = it },
        placeholder = { Text(stringResource(R.string.search_hint)) },
        leadingIcon = {
            Icon(
                modifier = Modifier.padding(start = 12.dp),
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MovemateColors.primary
            )
        },
        trailingIcon = {
            Image(
                modifier = Modifier
                    .background(color = MovemateColors.secondary, shape = CircleShape)
                    .padding(6.dp)
                    .size(24.dp)
                    .padding(2.dp),
                painter = painterResource(id = R.drawable.barcode),
                contentDescription = null,
            )
        },
        shape = CircleShape,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White
        ),
    )
}

@Preview
@Composable
fun SearchRowPreview() {
    SearchRow { }
}
