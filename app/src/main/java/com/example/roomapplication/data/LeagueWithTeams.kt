package com.example.roomapplication.data

import androidx.room.Embedded
import androidx.room.Relation

data class LeagueWithTeams(
    @Embedded val league: League,
    @Relation(
        parentColumn = "id",
        entityColumn = "leagueId"
    )
    val teams: List<Team>

)
