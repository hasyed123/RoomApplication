package com.example.roomapplication.domain.model

data class Team(
    val id: Int = 0,
    val name: String,
    val leagueId: Int,
    val wins: Int,
    val losses: Int,
    val ties: Int
)