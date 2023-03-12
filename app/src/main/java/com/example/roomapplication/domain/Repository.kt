package com.example.roomapplication.domain

import com.example.roomapplication.domain.model.Game
import com.example.roomapplication.domain.model.League
import com.example.roomapplication.domain.model.Team

interface Repository {

    suspend fun addLeague(league: League)

    suspend fun getLeagues(): List<League>

    suspend fun addTeam(team: Team)

    suspend fun getTeamsInLeague(leagueId: Int): List<Team>

    suspend fun addGame(game: Game)

    suspend fun getGamesInLeague(leagueId: Int): List<Game>

    suspend fun getTeamGames(teamName: String): List<Game>
}