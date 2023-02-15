package com.example.roomapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LeagueDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(league: League)

    @Query("SELECT * FROM league_table ORDER BY id ASC")
    suspend fun selectAll(): List<League>
}