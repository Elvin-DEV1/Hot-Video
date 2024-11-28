package com.example.hotvideo.di

import android.app.Application
import com.example.hotvideo.data.api.VideoApi
import com.example.hotvideo.data.manager.LocalUserManagerImpl
import com.example.hotvideo.data.repository.VideoRepositoryImpl
import com.example.hotvideo.domain.manager.LocalUserManager
import com.example.hotvideo.domain.repository.VideoRepository
import com.example.hotvideo.domain.usecases.app_entry.AppEntryUseCases
import com.example.hotvideo.domain.usecases.app_entry.ReadAppEntry
import com.example.hotvideo.domain.usecases.app_entry.SaveAppEntry
import com.example.hotvideo.domain.usecases.video.GetVideo
import com.example.hotvideo.domain.usecases.video.VideoUseCases
import com.example.hotvideo.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserManagerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

    @Provides
    @Singleton
    fun provideVideoApi(): VideoApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VideoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideVideoRepository(
        videoApi: VideoApi
    ): VideoRepository = VideoRepositoryImpl(videoApi)

    @Provides
    @Singleton
    fun provideVideoUseCases(
        videoRepository: VideoRepository
    ): VideoUseCases {
        return VideoUseCases(
            getVideo = GetVideo(videoRepository)
        )
    }
}