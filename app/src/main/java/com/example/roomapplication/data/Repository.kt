package com.example.roomapplication.data

import com.example.roomapplication.data.league.League
import com.example.roomapplication.data.league.LeagueDao
import com.example.roomapplication.data.team.LeagueWithTeams
import com.example.roomapplication.data.team.Team
import com.example.roomapplication.data.team.TeamDao
import javax.inject.Inject

class Repository @Inject constructor(
    private val leagueDao: LeagueDao,
    private val teamDao: TeamDao
) {
    suspend fun addLeague(league: League) {
        leagueDao.insert(league)
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
}