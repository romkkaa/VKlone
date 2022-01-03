package com.example.romanspirin.vklone.feed.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.romanspirin.vklone.feed.ui.NewsItem

@Composable
fun FeedItemCard(
    feedItem: NewsItem
) {
    Text(text = feedItem.text)
    Text(text = feedItem.name)
    AvatarImage(url = feedItem.avatarUrl)

}