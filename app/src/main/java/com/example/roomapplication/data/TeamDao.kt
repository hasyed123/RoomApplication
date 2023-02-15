package com.example.roomapplication.data

import androidx.room.*

@Dao
interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(team: Team)

    @Transaction
    @Query("SELECT * FROM team_table WHERE leagueId = :leagueId")
    suspend fun selectTeamsInLeague(leagueId: Int): LeagueWithTeams

}