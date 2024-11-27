package com.example.hotvideo.di

import android.app.Application
import com.example.hotvideo.data.manager.LocalUserManagerImpl
import com.example.hotvideo.domain.manager.LocalUserManager
import com.example.hotvideo.domain.usecases.AppEntryUseCases
import com.example.hotvideo.domain.usecases.ReadAppEntry
import com.example.hotvideo.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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

}