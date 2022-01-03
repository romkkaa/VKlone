package com.example.romanspirin.vklone.startup.ui

import androidx.lifecycle.ViewModel
import com.example.romanspirin.vklone.core.api.NewsService
import com.example.romanspirin.vklone.core.database.RoomLocalStorage
import com.example.romanspirin.vklone.core.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    val room: RoomLocalStorage
) : ViewModel() {

    suspend fun isLoggedIn(): Boolean {
        //var users: List<User>
        //runBlocking { room.userDao().deleteAllUsers() }
        //runBlocking { users = room.userDao().getAll() }
        //users
        val currentUser = room.userDao().getCurrentUser()
        return if (currentUser !== null && currentUser.access_token != null) {
            NewsService.access_token = currentUser.access_token
            true
        } else false
    }
}