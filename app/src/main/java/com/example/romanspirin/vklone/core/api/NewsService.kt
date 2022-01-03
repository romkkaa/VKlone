package com.example.romanspirin.vklone.core.api

import com.example.romanspirin.vklone.feed.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("method/newsfeed.getRecommended")
    suspend fun getRecommended(
        @Query("v") v: String = apiVersion,
        @Query("access_token") accessToken: String = access_token,
        @Query("start_from") startFrom: Int = 0,
        @Query("count") count: Int = 50
    ): NewsResponse

    companion object {
        const val apiVersion = "5.131"
        var access_token = ""
    }
}