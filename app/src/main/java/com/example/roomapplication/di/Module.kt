package com.example.roomapplication.di

import android.content.Context
import androidx.room.Room
import com.example.roomapplication.data.HockeyDatabase
import dagger.hilt.InstallIn
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Singleton
    @Provides
    fun provideHockeyDatabase(@ApplicationContext app: Context)
    = Room.databaseBuilder(
        app,
        HockeyDatabase::class.java,
        "hockey"
    ).build()

    @Singleton
    @Provides
    fun provideLeagueDao(db: HockeyDatabase) = db.leagueDao()

    @Singleton
    @Provides
    fun provideTeamDao(db: HockeyDatabase) = db.teamDao()

    @Singleton
    @Provides
    fun provideGameDao(db: HockeyDatabase) = db.gameDao()

}