package com.example.adaptive_nav_cmp.ui.screens.detail.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.adaptive_nav_cmp.data.models.YoutubeVideo
import com.example.adaptive_nav_cmp.utils.formatViews

@Composable
fun TitleViewsLayout(video: YoutubeVideo) {
    Text(
        text = video.title,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onSurface
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
        text = "${formatViews(video.views)} views • ${video.publishedTime}",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}