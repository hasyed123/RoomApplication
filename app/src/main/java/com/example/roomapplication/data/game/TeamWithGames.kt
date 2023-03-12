package com.example.roomapplication.data.game

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomapplication.data.team.TeamEntity

data class TeamWithGames(
    @Embedded
    val teamEntity: TeamEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "team1Id"
    )
    val games1: List<GameEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "team2Id"
    )
    val games2: List<GameEntity>
)
