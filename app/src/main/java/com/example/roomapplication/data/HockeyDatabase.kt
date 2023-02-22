package com.example.roomapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomapplication.data.league.League
import com.example.roomapplication.data.league.LeagueDao
import com.example.roomapplication.data.team.Team
import com.example.roomapplication.data.team.TeamDao

@Database(entities = [League::class, Team::class], version = 1, exportSchema = false)
abstract class HockeyDatabase: RoomDatabase() {

    abstract fun leagueDao(): LeagueDao
    abstract fun teamDao(): TeamDao
}