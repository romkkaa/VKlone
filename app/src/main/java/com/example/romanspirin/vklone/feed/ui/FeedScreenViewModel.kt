package com.example.romanspirin.vklone.feed.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.romanspirin.vklone.core.api.NewsService
import com.example.romanspirin.vklone.feed.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

const val PAGE_SIZE = 50

@HiltViewModel
class FeedScreenViewModel @Inject constructor(
    private val newsService: NewsService
) : ViewModel() {

    val news: MutableState<List<NewsItem>> = mutableStateOf(ArrayList(310))

    private val startFrom = mutableStateOf(0)

    private var loading = false
    private var listPosition = 0

    init {
        viewModelScope.launch { news.value = getRecommendedNewsItems(startFrom.value) }
    }

    private suspend fun getRecommendedNewsItems(startFrom: Int): List<NewsItem> {
        Log.d("FeedScreenViewModel", "getRecommendedNewsItems() triggered")

        val response: Response =
            newsService.getRecommended(startFrom = startFrom, count = PAGE_SIZE).response

        val items = response.items.map { item ->

            val group = if (item.source_id < 0) {
                response.groups.find { it.id == -item.source_id }
            } else null

            val profile = if (item.source_id > 0) {
                response.profiles.find { it.id == item.source_id }
            } else null

            NewsItem(
                text = item.text,
                avatarUrl = group?.photo_200 ?: profile!!.photo_200,
                name = group?.name ?: profile!!.first_name + profile.last_name
            )
        }
        Log.d("FeedScreenViewModel", "getRecommendedNewsItems() finishing...")
        return items
    }

    private fun nextPage() {
        viewModelScope.launch {
            loading = true
            incrementStartFrom()
            Log.d(
                "FeedScreenViewModel",
                "nextPage() triggered! startFrom = ${startFrom.value}"
            )
            if (startFrom.value > 0) appendNews(getRecommendedNewsItems(startFrom.value))
            loading = false
        }
    }

    fun onChangeFeedListScrollPosition(position: Int) {
        listPosition = position
        if ((position + 1) >= (startFrom.value + PAGE_SIZE / 1.5) && !loading) {
            nextPage()
        }
        Log.d(
            "FeedScreenViewModel",
            "Inside onChangeFeedListScrollPosition() position = $listPosition loading = $loading"
        )
    }

    private fun incrementStartFrom() {
        startFrom.value = startFrom.value + PAGE_SIZE
    }

    private fun appendNews(news: List<NewsItem>) {
//        val current = ArrayList(this.news.value)
//        current.addAll(news)
//        this.news.value = current
        this.news.value += news
    }

}

data class NewsItem(
    val text: String,
    val avatarUrl: String,
    val name: String,
)