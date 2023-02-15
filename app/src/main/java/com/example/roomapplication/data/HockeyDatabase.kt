package com.example.roomapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [League::class], version = 1, exportSchema = false)
abstract class HockeyDatabase: RoomDatabase() {

    abstract fun leagueDao(): LeagueDao

}