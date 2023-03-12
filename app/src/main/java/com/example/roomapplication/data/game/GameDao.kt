package com.example.roomapplication.data.game

import androidx.room.*

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(gameEntity: GameEntity)

    @Transaction
    @Query("SELECT * FROM league WHERE id = :leagueId")
    suspend fun selectGamesInLeague(leagueId: Int): LeagueWithGames?

    @Transaction
    @Query("SELECT * FROM team WHERE name = :name")
    suspend fun selectGamesInTeam(name: String): TeamWithGames?

    @Transaction
    @Query("SELECT leagueId FROM team WHERE name = :name")
    suspend fun getIdFromTeam(name: String): Int?


}