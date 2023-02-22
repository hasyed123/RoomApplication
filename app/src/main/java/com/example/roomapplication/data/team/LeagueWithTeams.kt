package com.example.roomapplication.data.team

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomapplication.data.league.League

data class LeagueWithTeams(
    @Embedded val league: League,
    @Relation(
        parentColumn = "id",
        entityColumn = "leagueId"
    )
    val teams: List<Team>

)
