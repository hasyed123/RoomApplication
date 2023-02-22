package com.example.roomapplication.data.game

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomapplication.data.league.League

data class LeagueWithGames (
    @Embedded
    val league: League,
    @Relation(
        parentColumn = "id",
        entityColumn = "leagueId"
    )
    val games: List<Game>
)