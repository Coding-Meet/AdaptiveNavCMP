package com.example.adaptive_nav_cmp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.adaptive_nav_cmp.data.dummy_data.DummyData
import com.example.adaptive_nav_cmp.ui.components.CenterTextScreen
import com.example.adaptive_nav_cmp.ui.screens.detail.VideoDetailScreen
import com.example.adaptive_nav_cmp.ui.screens.home.VideoListScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.HomeRoute
    ) {
        composable<Route.HomeRoute> {
            VideoListScreen(
                videos = DummyData.videos,
                onVideoClick = { video ->
                    navController.navigate(Route.VideoDetailRoute(video.id))
                }
            )
        }
        composable<Route.ShortsRoute> {
            CenterTextScreen("Shorts")
        }
        composable<Route.SubscriptionsRoute> {
            CenterTextScreen("Subscriptions")
        }
        composable<Route.LibraryRoute> {
            CenterTextScreen("Library")
        }
        composable<Route.VideoDetailRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<Route.VideoDetailRoute>()
            val video = DummyData.videos.find { it.id == route.videoId }
            video?.let {
                VideoDetailScreen(
                    video = video,
                    onBackClick = { navController.navigateUp() }
                )
            }
        }
    }
}