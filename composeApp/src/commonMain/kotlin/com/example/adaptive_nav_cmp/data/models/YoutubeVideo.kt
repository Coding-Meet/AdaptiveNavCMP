package com.example.adaptive_nav_cmp.data.models

import org.jetbrains.compose.resources.DrawableResource

data class YoutubeVideo(
    val id: String, // 1,2,3,4,
    val title: String,
    val description: String,
    val thumbnailUrl: DrawableResource,  // Res.drawable.*
    val channelName: String, // Coding Meet
    val channelLogoUrl: DrawableResource, // Res.drawable.coding_meet
    val views: Long,
    val publishedTime: String,
    val duration: String
)