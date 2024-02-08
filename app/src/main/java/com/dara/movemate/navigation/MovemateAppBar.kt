package com.dara.movemate.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import com.dara.movemate.R
import com.dara.movemate.navigation.MovemateScreen.Calculate
import com.dara.movemate.navigation.MovemateScreen.Home
import com.dara.movemate.navigation.MovemateScreen.Profile
import com.dara.movemate.navigation.MovemateScreen.Shipment

@Composable
fun MovemateAppBar(
    currentDestination: NavDestination?,
    onBottomTabSelected: (BottomTab) -> Unit,
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background
    ) {
        BOTTOM_TABS.forEach { tab ->
            val isSelected = currentDestination?.route == tab.route
            NavigationBarItem(
                selected = isSelected,
                onClick = { onBottomTabSelected(tab) },
                icon = {
                    Icon(
                        painter = painterResource(id = tab.icon),
                        contentDescription = null
                    )
                },
                label = { Text(text = stringResource(id = tab.labelId)) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = Color.Gray,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = Color.Gray,
                    indicatorColor = MaterialTheme.colorScheme.background
                )
            )

        }
    }
}

enum class MovemateScreen {
    Home,
    Calculate,
    Shipment,
    Profile
}

data class BottomTab(
    val labelId: Int,
    val icon: Int,
    val route: String
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
