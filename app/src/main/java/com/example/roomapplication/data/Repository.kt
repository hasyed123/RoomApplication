package com.example.roomapplication.data

import com.example.roomapplication.data.game.Game
import com.example.roomapplication.data.game.GameDao
import com.example.roomapplication.data.game.TeamWithGames
import com.example.roomapplication.data.league.League
import com.example.roomapplication.data.league.LeagueDao
import com.example.roomapplication.data.team.LeagueWithTeams
import com.example.roomapplication.data.team.Team
import com.example.roomapplication.data.team.TeamDao
import javax.inject.Inject

class Repository @Inject constructor(
    private val leagueDao: LeagueDao,
    private val teamDao: TeamDao,
    private val gameDao: GameDao
) {
    suspend fun addLeague(league: League) {
        val id = leagueDao.insert(league)
        createSampleData(id.toInt())
    }

    suspend fun createSampleData(id: Int) {
        for(i in 0..5) {
            teamDao.insert(Team("League${id}Team$i", id))
        }
        val teamList = teamDao.selectTeamsInLeague(id)?.teams
        teamList?.let {
            for (team1 in it) {
                for (team2 in it) {
                    addGame(team1.name, team2.name)
                }
            }
        }
    }

    suspend fun getLeagues(): List<League> {
        return leagueDao.selectAll()
    }

    suspend fun addTeam(team: Team) {
        teamDao.insert(team)
    }

    suspend fun getTeams(leagueId: Int): LeagueWithTeams? {
        return teamDao.selectTeamsInLeague(leagueId)
    }

    suspend fun addGame(team1: String, team2: String) {
        gameDao.insertGameByParams(team1, team2)
    }

    suspend fun getTeamGames(teamName: String): TeamWithGames? {
        return gameDao.selectGamesInTeam(teamName)
    }
}