package com.dara.movemate.ui.composables.calculate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.movemate.R
import com.dara.movemate.data.Category
import com.dara.movemate.ui.composables.components.LabelText
import com.dara.movemate.ui.composables.components.SecondaryText
import com.dara.movemate.ui.theme.navy_blue

@Composable
fun CategoriesComponent() {
    val categories = listOf(
        Category("Documents"),
        Category("Glass"),
        Category("Liquid"),
        Category("Food"),
        Category("Electronic"),
        Category("Product"),
        Category("Others"),
    )
    Column(
        Modifier.padding(16.dp)
    ) {
        LabelText(
            textId = R.string.categories,
        )
        SecondaryText(
            textId = R.string.what_are_you_sending,
            modifier = Modifier.padding(top = 6.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        CategoryChips(categories)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoryChips(
    categories: List<Category>
) {

    FlowRow {
        categories.forEach { CategoryChip(category = it) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryChip(category: Category) {
    var selected by remember { mutableStateOf(category.isSelected) }

    FilterChip(
        modifier = Modifier.padding(end = 8.dp),
        onClick = { selected = !selected },
        label = {
            Text(
                text = category.name,
                modifier = Modifier.padding(vertical = 8.dp),
                color = if (selected) Color.White else navy_blue,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize),
                    tint = Color.White
                )
            }
        } else {
            null
        },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = navy_blue,
        ),
        border = FilterChipDefaults.filterChipBorder(
            borderWidth = 1.5.dp,
            borderColor = Color.Gray.copy(alpha = 0.7F)
        )
    )
}

@Preview
@Composable
fun CategoriesComponentPreview() {
    CategoriesComponent()
}
