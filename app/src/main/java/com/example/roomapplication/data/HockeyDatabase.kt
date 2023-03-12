package com.example.roomapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomapplication.data.game.GameEntity
import com.example.roomapplication.data.game.GameDao
import com.example.roomapplication.data.league.LeagueEntity
import com.example.roomapplication.data.league.LeagueDao
import com.example.roomapplication.data.team.TeamEntity
import com.example.roomapplication.data.team.TeamDao

@Database(entities = [LeagueEntity::class, TeamEntity::class, GameEntity::class], version = 1, exportSchema = false)
abstract class HockeyDatabase: RoomDatabase() {

    abstract fun leagueDao(): LeagueDao
    abstract fun teamDao(): TeamDao

    abstract fun gameDao(): GameDao
}