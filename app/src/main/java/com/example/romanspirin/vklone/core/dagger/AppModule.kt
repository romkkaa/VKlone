package com.example.romanspirin.vklone.core.dagger

import android.app.Application
import androidx.room.Room
import com.example.romanspirin.vklone.core.database.RoomLocalStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideRoom(context: Application): RoomLocalStorage {
        return Room.databaseBuilder(
            context,
            RoomLocalStorage::class.java,
            "storage"
        ).build()
    }
}