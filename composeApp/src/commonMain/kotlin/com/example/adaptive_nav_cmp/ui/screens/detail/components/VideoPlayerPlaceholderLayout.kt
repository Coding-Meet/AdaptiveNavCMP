package com.example.adaptive_nav_cmp.ui.screens.detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.adaptive_nav_cmp.data.models.YoutubeVideo
import org.jetbrains.compose.resources.painterResource

@Composable
fun VideoPlayerPlaceholderLayout(video: YoutubeVideo) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .wrapContentWidth()
            .widthIn(max = 720.dp)
            .aspectRatio(16f / 9f),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(video.thumbnailUrl),
            contentDescription = video.title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        //  Play button overlay
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "Play",
            modifier = Modifier.size(64.dp),
            tint = Color.White.copy(alpha = 0.8f)
        )
    }
}