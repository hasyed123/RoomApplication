package com.example.roomapplication.data.league

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LeagueDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(leagueEntity: LeagueEntity): Long

    @Query("SELECT * FROM league ORDER BY id ASC")
    suspend fun selectAll(): List<LeagueEntity>
}