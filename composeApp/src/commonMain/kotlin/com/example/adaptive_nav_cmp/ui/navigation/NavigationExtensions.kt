package com.example.adaptive_nav_cmp.ui.navigation

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import kotlin.reflect.KClass

/**
 * Checks if the specified [route] class exists anywhere in the current destination's hierarchy.
 * * This is useful for determining if a screen belongs to a specific navigation group or tab,
 * even if the user has navigated to a nested child destination.
 *
 * @param route The Kotlin Class of the navigation route to search for.
 * @return True if the route is found in the hierarchy, false otherwise.
 */
fun NavBackStackEntry?.isRouteInHierarchy(route: KClass<*>) =
    this?.destination?.hierarchy?.any {
        it.hasRoute(route)
    } == true
