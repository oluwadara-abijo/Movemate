package com.dara.movemate.navigation

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateIntOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import com.dara.movemate.R
import com.dara.movemate.navigation.MovemateScreen.Calculate
import com.dara.movemate.navigation.MovemateScreen.Home
import com.dara.movemate.navigation.MovemateScreen.Profile
import com.dara.movemate.navigation.MovemateScreen.Shipment
import com.dara.movemate.ui.theme.Dimens.tweenAnimationDuration
import com.dara.movemate.ui.theme.MovemateColors

@Composable
fun MovemateBottomBar(
    currentDestination: NavDestination?,
    onBottomTabSelected: (BottomTab) -> Unit,
    isVisible: Boolean,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val indicatorWidth = (screenWidth / 4).dp
    var startingPoint by remember { mutableIntStateOf(0) }

    // Reset indicator
    if (currentDestination?.route == "Home") {
        startingPoint = 0
    }

    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(
            animationSpec = tween(tweenAnimationDuration),
            initialOffsetY = { fullHeight -> fullHeight * 2 }),
        exit = slideOutVertically(
            animationSpec = tween(tweenAnimationDuration),
            targetOffsetY = { fullHeight -> fullHeight * 2 })
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {

            Indicator(
                width = indicatorWidth,
                startingPoint = startingPoint
            )

            Spacer(modifier = Modifier.size(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp),
            ) {
                BOTTOM_TABS.forEach { tab ->
                    BottomTabItem(
                        modifier = Modifier.weight(1F),
                        tab = tab,
                        isSelected = currentDestination?.route == tab.route,
                        onTabSelected = {
                            startingPoint = getStartingPoint(screenWidth, tab.route)
                            onBottomTabSelected(tab)
                        }
                    )
                }
            }
        }

    }
}

@Composable
fun BottomTabItem(
    modifier: Modifier = Modifier,
    tab: BottomTab,
    isSelected: Boolean,
    onTabSelected: (BottomTab) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable {
                onTabSelected(tab)
            }
    ) {
        val color = if (isSelected) MovemateColors.primary else Color.Gray
        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = tab.icon),
            contentDescription = null,
            tint = color
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = stringResource(id = tab.labelId),
            fontSize = 14.sp,
            color = color,
        )
    }
}

@Composable
fun Indicator(width: Dp, startingPoint: Int) {

    val newPosition = with(LocalDensity.current) {
        startingPoint.dp.toPx().toInt()
    }

    val offset by animateIntOffsetAsState(
        targetValue = IntOffset(x = newPosition, y = 0),
        animationSpec = tween(durationMillis = tweenAnimationDuration, easing = FastOutSlowInEasing),
        label = "offset"
    )

    Box(
        modifier = Modifier
            .offset { offset }
            .background(color = MovemateColors.primary)
            .size(width = width, height = 4.dp)
    )
}

fun getStartingPoint(screenWidth: Int, currentDestination: String): Int {
    return when (currentDestination) {
        BOTTOM_TABS[1].route -> screenWidth / 4
        BOTTOM_TABS[2].route -> (screenWidth / 4) * 2
        BOTTOM_TABS[3].route -> (screenWidth / 4) * 3
        else -> 0
    }
}

enum class MovemateScreen {
    Home,
    Calculate,
    Shipment,
    Profile,
    Estimate,
}

data class BottomTab(
    val labelId: Int,
    @DrawableRes val icon: Int,
    val route: String,
)

val BOTTOM_TABS = listOf(
    BottomTab(
        labelId = R.string.home,
        icon = R.drawable.home,
        route = Home.name
    ),
    BottomTab(
        labelId = R.string.calculate,
        icon = R.drawable.calculate,
        route = Calculate.name
    ),
    BottomTab(
        labelId = R.string.shipment,
        icon = R.drawable.history,
        route = Shipment.name
    ),
    BottomTab(
        labelId = R.string.profile,
        icon = R.drawable.person,
        route = Profile.name
    ),
)
