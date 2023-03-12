package com.example.roomapplication.data.game

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomapplication.data.league.LeagueEntity

data class LeagueWithGames (
    @Embedded
    val leagueEntity: LeagueEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "leagueId"
    )
    val gameEntities: List<GameEntity>
)