package com.example.adaptive_nav_cmp.ui.screens.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.adaptive_nav_cmp.data.models.YoutubeVideo

@Composable
fun VideoInfoLayout(video: YoutubeVideo) {
    Column(modifier = Modifier.padding(12.dp)) {
        // Title and Views
        TitleViewsLayout(video)

        Spacer(modifier = Modifier.height(16.dp))

        // Action Buttons
        ActionButtons()

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        Spacer(modifier = Modifier.height(16.dp))

        // Channel Info
        ChannelInfoLayout(video)

        Spacer(modifier = Modifier.height(16.dp))

        // Description
        DescriptionLayout(video)

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        Spacer(modifier = Modifier.height(16.dp))

        // Comments Section
        CommentsLayout()
    }
}

