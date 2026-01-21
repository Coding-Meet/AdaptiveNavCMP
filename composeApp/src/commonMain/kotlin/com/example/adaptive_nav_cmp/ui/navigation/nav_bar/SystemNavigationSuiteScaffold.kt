package com.example.adaptive_nav_cmp.ui.navigation.nav_bar

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldState
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScope
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.runtime.Composable

/**
 * A custom wrapper for [NavigationSuiteScaffold] that adaptively switches between
 * a Bottom Navigation Bar, Navigation Rail, or Navigation Drawer based on the [layoutType].
 *
 * @param navigationSuiteState Controls the visibility (show/hide) of the navigation component.
 * @param layoutType The current layout strategy (e.g., BottomBar for mobile, Rail for tablets).
 * @param currentNavigationItem The currently active [NavItem], used to highlight the selection.
 * @param onNavigationItemClick Callback triggered when a navigation item is pressed.
 * @param content The main UI content to be displayed alongside the navigation suite.
 */
@Composable
fun SystemNavigationSuiteScaffold(
    navigationSuiteState: NavigationSuiteScaffoldState,
    layoutType: NavigationSuiteType,
    currentNavigationItem: NavItem?,
    onNavigationItemClick: (NavItem) -> Unit,
    content: @Composable () -> Unit
) {
    NavigationSuiteScaffold(
        state = navigationSuiteState,
        navigationSuiteItems = {
            // Populate the navigation items (tabs/links)
            systemNavBar(
                currentNavigationItem = currentNavigationItem,
                onNavigationItemClick = onNavigationItemClick
            )
        },
        layoutType = layoutType,
        navigationSuiteColors = NavigationSuiteDefaults.colors(
            /*
               Custom colors can be defined here to override
               the default Material 3 adaptive behavior.
            */
        ),
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        content = content
    )
}

/**
 * Extension function for [NavigationSuiteScope] to define the items
 * within the navigation bar/rail.
 *
 * It iterates through all [NavItem.entries] and configures their icons,
 * labels, and selection states.
 */
fun NavigationSuiteScope.systemNavBar(
    currentNavigationItem: NavItem?,
    onNavigationItemClick: (NavItem) -> Unit
) {
    NavItem.entries.forEach { navItem ->
        // Check if this specific item is the one currently selected by the user
        val selected = currentNavigationItem == navItem

        item(
            icon = {
                // Toggle between Filled and Outlined icons based on selection state
                Icon(
                    imageVector = if (selected) navItem.selectedIcon else navItem.unselectedIcon,
                    contentDescription = navItem.label
                )
            },
            label = { Text(navItem.label) },
            selected = selected,
            onClick = {
                onNavigationItemClick(navItem)
            }
        )
    }
}