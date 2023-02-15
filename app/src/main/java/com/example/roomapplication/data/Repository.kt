package com.example.roomapplication.data

import javax.inject.Inject

class Repository @Inject constructor(
    private val leagueDao: LeagueDao
) {
    suspend fun addLeague(league: League) {
        leagueDao.addLeague(league)
    }
}