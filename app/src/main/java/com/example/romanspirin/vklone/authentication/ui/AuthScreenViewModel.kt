package com.example.romanspirin.vklone.authentication.ui

import androidx.lifecycle.ViewModel
import com.example.romanspirin.vklone.core.database.RoomLocalStorage
import com.example.romanspirin.vklone.core.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthScreenViewModel @Inject constructor(
    val room: RoomLocalStorage
) : ViewModel() {

    val authUrl =
        "https://oauth.vk.com/authorize?client_id=8040378&redirect_uri=https://oauth.vk.com/blank.html&display=mobile&scope=notify,friends,photos,audio,video,stories,pages,status,notes,wall,ads,docs,groups,notifications,stats,email,market&response_type=token&state=13579"
        //"https://oauth.vk.com/authorize?client_id=8040378&redirect_uri=https://oauth.vk.com/blank.html&display=mobile&response_type=token&state=13579"

    suspend fun updateAccessToken(url: String) {
        room.userDao().deleteAllUsers()
        val token = url.split("access_token=")[1].split("&expires")[0]
        room.userDao().saveUser(User(access_token = token, isCurrent = true))
    }

}