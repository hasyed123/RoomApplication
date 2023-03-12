package com.example.roomapplication.data.team

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomapplication.data.league.LeagueEntity

data class LeagueWithTeams(
    @Embedded val leagueEntity: LeagueEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "leagueId"
    )
    val teamEntities: List<TeamEntity>

)
