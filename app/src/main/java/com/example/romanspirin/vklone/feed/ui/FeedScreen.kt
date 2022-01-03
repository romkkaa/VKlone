package com.example.romanspirin.vklone.feed.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.romanspirin.vklone.core.ui.theme.Teal200
import com.example.romanspirin.vklone.feed.ui.components.LazyFeedList

@Composable
fun FeedScreen(
    navController: NavHostController
) {
    val vm: FeedScreenViewModel = hiltViewModel()

    Box(
        modifier = Modifier
            .background(Teal200)
            .fillMaxSize(),
    ) {
        LazyFeedList(
            feedItems = vm.news.value,
        )
    }
}
