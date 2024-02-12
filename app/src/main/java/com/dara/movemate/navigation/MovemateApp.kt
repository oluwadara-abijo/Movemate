package com.dara.movemate.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dara.movemate.navigation.MovemateScreen.Calculate
import com.dara.movemate.navigation.MovemateScreen.Estimate
import com.dara.movemate.navigation.MovemateScreen.Home
import com.dara.movemate.navigation.MovemateScreen.Profile
import com.dara.movemate.navigation.MovemateScreen.Shipment
import com.dara.movemate.ui.composables.ProfileScreen
import com.dara.movemate.ui.composables.shipment.ShipmentScreen
import com.dara.movemate.ui.composables.calculate.CalculateScreen
import com.dara.movemate.ui.composables.calculate.EstimateScreen
import com.dara.movemate.ui.composables.home.HomeScreen
import com.dara.movemate.ui.theme.MovemateColors

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MovemateApp() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val topLevelRoutes = listOf(Home.name, Profile.name)
    val shouldShowBottomBar = topLevelRoutes.contains(currentDestination?.route)

    Scaffold(
        modifier = Modifier
            .background(MovemateColors.background)
            .systemBarsPadding()
            .navigationBarsPadding(),
        bottomBar = {
            MovemateBottomBar(
                currentDestination = currentDestination,
                onBottomTabSelected = navController::navigateToBottomTab,
                isVisible = shouldShowBottomBar
            )
        },
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
    ) { paddingValues ->
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .consumeWindowInsets(paddingValues),
            navController = navController,
            startDestination = Home.name
        ) {
            composable(Home.name) { HomeScreen() }
            composable(Calculate.name) {
                CalculateScreen(
                    navigateBack = navController::navigateUp,
                    onCalculateClicked = { navController.navigate(Estimate.name) }
                )
            }
            composable(Shipment.name) {
                ShipmentScreen(
                    navigateBack = navController::navigateUp
                )
            }
            composable(Profile.name) { ProfileScreen() }
            composable(Estimate.name) { EstimateScreen() }
        }

    }
}
