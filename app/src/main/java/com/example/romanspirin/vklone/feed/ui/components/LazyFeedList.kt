package com.example.romanspirin.vklone.feed.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.romanspirin.vklone.feed.ui.FeedScreenViewModel
import com.example.romanspirin.vklone.feed.ui.NewsItem
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues

@Composable
fun LazyFeedList(
    feedItems: List<NewsItem>,
) {
    val vm: FeedScreenViewModel = hiltViewModel()

    LazyColumn(
        contentPadding = rememberInsetsPaddingValues(
            insets = LocalWindowInsets.current.systemBars,
            applyTop = true,
            applyBottom = true,
        )
    ) {
        itemsIndexed(feedItems) { index, item ->
            vm.onChangeFeedListScrollPosition(index)
            FeedItemCard(feedItem = item)
        }
    }
}