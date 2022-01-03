package com.example.romanspirin.vklone.feed.model

data class NewsResponse(
    val response: Response
)

data class Response(
    val items: List<Item>,
    val profiles: List<Profile>,
    val groups: List<Group>,
    val next_from: String,
)

data class Group(
    val id: Long,
    val name: String,
    val photo_200: String,
)

data class Item(
    val source_id: Long,
    val date: Long,
    val post_type: String,
    val text: String,
)

data class Profile(
    val id: Long,
    val first_name: String,
    val last_name: String,
    val photo_200: String,
)