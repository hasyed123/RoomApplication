package com.example.roomapplication.data

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
}