package com.example.romanspirin.vklone.core.dagger

import android.app.Application
import androidx.room.Room
import com.example.romanspirin.vklone.core.api.NewsService
import com.example.romanspirin.vklone.core.database.RoomLocalStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.vk.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideRoom(context: Application): RoomLocalStorage {
        return Room.databaseBuilder(
            context,
            RoomLocalStorage::class.java,
            "storage"
        ).build()
    }

    @Provides
    @Singleton
    fun provideNewsService(context: Application): NewsService {
        return retrofit.create(NewsService::class.java)
    }
}