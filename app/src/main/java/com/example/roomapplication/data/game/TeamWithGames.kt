package com.example.roomapplication.data.game

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomapplication.data.league.League
import com.example.roomapplication.data.team.Team

data class TeamWithGames(
    @Embedded
    val team: Team,
    @Relation(
        parentColumn = "name",
        entityColumn = "team1"
    )
    val games1: List<Game>,
    @Relation(
        parentColumn = "name",
        entityColumn = "team2"
    )
    val games2: List<Game>
)
