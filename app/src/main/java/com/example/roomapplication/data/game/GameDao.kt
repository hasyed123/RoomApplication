package com.example.roomapplication.data.game

import androidx.room.*

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(game: Game)

    @Transaction
    @Query("SELECT * FROM league WHERE id = :leagueId")
    suspend fun selectGamesInLeague(leagueId: Int): LeagueWithGames?

    @Transaction
    @Query("SELECT * FROM team WHERE name = :name")
    suspend fun selectGamesInTeam(name: String): TeamWithGames?

    @Transaction
    @Query("SELECT leagueId FROM team WHERE name = :name")
    suspend fun getIdFromTeam(name: String): Int?

    @Transaction
    suspend fun insertGameByParams(team1: String, team2: String) {
        if(team1 == team2) return
        val id1 = getIdFromTeam(team1)
        val id2 = getIdFromTeam(team2)
        if(id1 != null && id1 == id2) {
            insert(Game(0, team1, team2, id1))
        }
    }

}