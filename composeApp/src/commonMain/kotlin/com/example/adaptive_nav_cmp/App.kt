package com.example.adaptive_nav_cmp

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffoldDefaults
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteType
import androidx.compose.material3.adaptive.navigationsuite.rememberNavigationSuiteScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.adaptive_nav_cmp.ui.navigation.AppNavHost
import com.example.adaptive_nav_cmp.ui.navigation.Route
import com.example.adaptive_nav_cmp.ui.navigation.isRouteInHierarchy
import com.example.adaptive_nav_cmp.ui.navigation.nav_bar.CustomNavigationSuiteScaffoldLayout
import com.example.adaptive_nav_cmp.ui.navigation.nav_bar.NavItem
import com.example.adaptive_nav_cmp.ui.navigation.nav_bar.SystemNavigationSuiteScaffold
import com.example.adaptive_nav_cmp.ui.navigation.nav_bar.customNavigationSuiteType
import com.example.adaptive_nav_cmp.ui.theme.YoutubeTheme
import com.example.adaptive_nav_cmp.utils.calculateWindowSizeClass

@Composable
@Preview
fun App() {
    YoutubeTheme(false) {
        val navController = rememberNavController()
        val navigationSuiteState = rememberNavigationSuiteScaffoldState()
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        /**
         * Determines which top-level [NavItem] corresponds to the current navigation state.
         *
         * This searches through all [NavItem.entries] to see if the current route
         * or any of its parent routes match. If no match is found (e.g., on a detail screen),
         * this will be null.
         */
        val currentNavigationItem by remember(navBackStackEntry) {
            derivedStateOf {
                NavItem.entries.find { navigationItem ->
                    navBackStackEntry.isRouteInHierarchy(navigationItem.route::class)
                }
            }
        }

        /**
         * Automatically shows or hides the Navigation Suite (Bottom Bar/Rail)
         * based on the current destination.
         *
         * If the current route is a top-level destination (found in NavItem), the bar is shown.
         * If the user navigates to a detail screen (not in NavItem), the bar is hidden
         * to provide a full-screen experience.
         */
        LaunchedEffect(currentNavigationItem) {
            if (currentNavigationItem != null) {
                navigationSuiteState.show()
            } else {
                navigationSuiteState.hide()
            }
        }

        /**
         * Automatically determines the appropriate navigation UI type based on the device configuration.
         *
         * It uses [currentWindowAdaptiveInfo] to detect screen size and posture (e.g., folded vs unfolded).
         */
        val windowAdaptiveInfo = currentWindowAdaptiveInfo()


        /**
         * Check [NavigationSuiteScaffoldDefaults.navigationSuiteType] Method:
         * - On Mobile: Usually returns [NavigationSuiteType.ShortNavigationBarCompact] (Bottom Bar).
         * - On Tablets/Desktop: Usually returns [NavigationSuiteType.ShortNavigationBarMedium] or [NavigationSuiteType.WideNavigationRailCollapsed].
         */
        val layoutType = NavigationSuiteScaffoldDefaults.navigationSuiteType(
            adaptiveInfo = windowAdaptiveInfo
        )

        val windowSizeClass = calculateWindowSizeClass()

        val customLayoutType = customNavigationSuiteType(windowSizeClass)

        CustomNavigationSuiteScaffoldLayout(
            navigationSuiteState = navigationSuiteState,
            layoutType = customLayoutType,
            currentNavigationItem = currentNavigationItem,
            onNavigationItemClick = { navItem ->
                navController.navigate(navItem.route) {
                    popUpTo(Route.HomeRoute) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            content = {
                AppNavHost(navController = navController)
            }
        )

        SystemNavigationSuiteScaffold(
            navigationSuiteState = navigationSuiteState,
            layoutType = customLayoutType,
            currentNavigationItem = currentNavigationItem,
            onNavigationItemClick = { navItem ->
                navController.navigate(navItem.route) {
                    popUpTo(Route.HomeRoute) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            content = {
                AppNavHost(navController = navController)
            }
        )

    }
}