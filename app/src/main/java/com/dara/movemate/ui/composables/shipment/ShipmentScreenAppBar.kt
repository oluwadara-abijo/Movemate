package com.dara.movemate.ui.composables.shipment

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dara.movemate.R
import com.dara.movemate.data.ShipmentStatus
import com.dara.movemate.ui.composables.components.BackButton
import com.dara.movemate.ui.composables.components.LabelText
import com.dara.movemate.ui.theme.MovemateColors
import com.dara.movemate.ui.theme.badgeContainerColor
import com.dara.movemate.ui.theme.badgeTextColor

@Composable
fun ShipmentScreenAppBar(
    navigateBack: () -> Unit,
    filterShipments: (ShipmentStatus?) -> Unit,
) {
    var animateComponents by remember { mutableStateOf(false) }

    val appBarHeight by animateDpAsState(
        targetValue = if (animateComponents) 113.dp else 180.dp,
        animationSpec = tween(durationMillis = 1000),
        label = "offset"
    )

    LaunchedEffect(Unit) {
        animateComponents = true
    }

    Column(
        modifier = Modifier
            .animateContentSize()
            .fillMaxWidth()
            .height(appBarHeight)
            .background(MovemateColors.primary)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BackButton(animateComponents, navigateBack)
            AnimatedVisibility(
                visible = animateComponents,
                enter = slideInVertically(
                    animationSpec = tween(1000),
                    initialOffsetY = { fullHeight -> fullHeight * 2 })
            ) {
                LabelText(
                    textId = R.string.shipment_history, textColor = White
                )
            }
            Spacer(Modifier.size(48.dp))
        }
        Spacer(Modifier.size(16.dp))
        ShipmentTabRow(
            filterShipments = filterShipments,
            animateComponents = animateComponents
        )
    }
}

@Composable
fun ShipmentTabRow(
    filterShipments: (ShipmentStatus?) -> Unit,
    animateComponents: Boolean
) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("All", "Completed", "In progress", "Pending order", "Cancelled")

    AnimatedVisibility(
        visible = animateComponents,
        enter = slideInHorizontally(
            animationSpec = tween(1000),
            initialOffsetX = { fullWidth -> fullWidth * 2 })
    ) {
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = MovemateColors.primary,
            contentColor = White,
            edgePadding = 0.dp,
            divider = { Divider(color = Transparent) },
            indicator = { tabPositions ->
                AnimatedVisibility(
                    visible = true,
                    enter = slideInVertically(
                        animationSpec = tween(1000),
                        initialOffsetY = { fullHeight -> fullHeight * 2 })
                ) {
                    TabRowDefaults.Indicator(
                        modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        color = MovemateColors.secondary
                    )
                }
            }
        ) {
            tabs.forEachIndexed { index, tab ->
                val tabCount = when (index) {
                    0 -> 12
                    1 -> 5
                    2 -> 3
                    3 -> 4
                    4 -> 1
                    else -> 0
                }

                Tab(
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                        val currentFilter = when (selectedTabIndex) {
                            1 -> ShipmentStatus.Completed
                            2 -> ShipmentStatus.InProgress
                            3 -> ShipmentStatus.Pending
                            4 -> ShipmentStatus.Cancelled
                            else -> null
                        }
                        filterShipments(currentFilter)
                    },
                    text = {
                        TabLabel(
                            title = tab,
                            count = tabCount,
                            isSelected = selectedTabIndex == index
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun TabLabel(
    title: String,
    count: Int,
    isSelected: Boolean
) {
    Row(
        verticalAlignment = CenterVertically,
        modifier = Modifier.padding(bottom = 4.dp)
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(end = 4.dp),
            fontSize = 18.sp,
            color = if (isSelected) White else badgeTextColor
        )
        Text(
            modifier = Modifier
                .background(
                    color = if (isSelected) MovemateColors.secondary.copy(alpha = 0.75F)
                    else badgeContainerColor,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(vertical = 1.dp, horizontal = 8.dp),
            text = count.toString(),
            fontSize = 13.sp,
            color = if (isSelected) White else badgeTextColor
        )
    }
}

@Preview
@Composable
fun ShipmentScreenAppBarPreview() {
    ShipmentScreenAppBar(navigateBack = {}, filterShipments = {})
}
