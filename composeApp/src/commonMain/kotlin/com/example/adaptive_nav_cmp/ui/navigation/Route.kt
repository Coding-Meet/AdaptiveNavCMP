package com.example.adaptive_nav_cmp.ui.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object HomeRoute : Route

    @Serializable
    data object ShortsRoute : Route

    @Serializable
    data object SubscriptionsRoute : Route
    
    @Serializable
    data object LibraryRoute : Route

    @Serializable
    data class VideoDetailRoute(val videoId: String) : Route
    
}