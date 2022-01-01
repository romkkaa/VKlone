package com.example.romanspirin.vklone.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.romanspirin.vklone.core.model.User

@Database(entities = [User::class], version = 1)
abstract class RoomLocalStorage : RoomDatabase() {
    abstract fun userDao(): UserDao
}