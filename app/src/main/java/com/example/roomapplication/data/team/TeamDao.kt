package com.example.roomapplication.data.team

import androidx.room.*

@Dao
interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(teamEntity: TeamEntity)

    @Transaction
    @Query("SELECT * FROM league WHERE id = :leagueId")
    suspend fun selectTeamsInLeague(leagueId: Int): LeagueWithTeams?

}