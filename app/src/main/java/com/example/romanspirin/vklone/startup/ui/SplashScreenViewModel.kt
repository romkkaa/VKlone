package com.example.romanspirin.vklone.startup.ui

import androidx.lifecycle.ViewModel
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
        var user: List<User>
        runBlocking { user = room.userDao().getAll() }
        user

        return room.userDao().getCurrentUser()?.let { it.access_token != null } ?: false
    }
}