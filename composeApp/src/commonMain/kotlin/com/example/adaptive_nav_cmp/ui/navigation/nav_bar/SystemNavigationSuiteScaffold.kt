package com.example.adaptive_nav_cmp.ui.navigation.nav_bar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldState
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScope
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.material3.adaptive.navigationsuite.rememberNavigationSuiteScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.adaptive_nav_cmp.ui.theme.YoutubeTheme
import com.example.adaptive_nav_cmp.utils.AllAdaptivePreviews

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

@AllAdaptivePreviews
@Composable
fun SystemNavigationPreview() {
    YoutubeTheme {
        /**
         * Automatically determines the appropriate navigation UI type based on the device configuration.
         *
         * It uses [currentWindowAdaptiveInfo] to detect screen size and posture (e.g., folded vs unfolded).
         */
        val windowAdaptiveInfo = currentWindowAdaptiveInfo()

        /**
         * - notes: If use custom navigationSuiteType with inbuilt NavigationSuiteScaffold return only [NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo]
         * return [NavigationSuiteType.NavigationBar] or [NavigationSuiteType.NavigationRail]
         */
        val inbuiltLayoutType = NavigationSuiteScaffoldDefaults.calculateFromAdaptiveInfo(
            adaptiveInfo = windowAdaptiveInfo
        )
        SystemNavigationSuiteScaffold(
            navigationSuiteState = rememberNavigationSuiteScaffoldState(),
            layoutType = inbuiltLayoutType,
            currentNavigationItem = NavItem.HOME,
            onNavigationItemClick = {}
        ) {
            Scaffold {
                Box(
                    modifier = Modifier.fillMaxSize().padding(it),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Custom Navigation Preview")
                }
            }
        }
    }
}
