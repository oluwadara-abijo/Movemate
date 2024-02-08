package com.dara.movemate.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

/**
 * Helper method to handle navigation to bottom tab destinations
 */
internal fun NavHostController.navigateToBottomTab(
    tab: BottomTab
) {
    navigate(tab.route) {
        popUpTo(graph.findStartDestination().id) {
            // Save the state of the destinations
            saveState = true
        }
        // Prevent a tab from re-launching if tab is re-selected
        launchSingleTop = true
        // Restore the state of the new destination
        restoreState = true
    }
}
