package com.example.roomapplication.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LeagueDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLeague(league: League)

    @Query("SELECT * FROM league_table ORDER BY id ASC")
    suspend fun getLeagues(): List<League>
}