package com.example.roomapplication.data.game

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.roomapplication.data.league.LeagueEntity
import com.example.roomapplication.data.team.TeamEntity

@Entity(
    tableName = "game",
    foreignKeys = [
        ForeignKey(
            entity = LeagueEntity::class,
            parentColumns = ["id"],
            childColumns = ["leagueId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = TeamEntity::class,
            parentColumns = ["id"],
            childColumns = ["team1Id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = TeamEntity::class,
            parentColumns = ["id"],
            childColumns = ["team2Id"],
            onDelete = ForeignKey.CASCADE
        ),
    ]
)
data class GameEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val team1Id: Int,
    val team2Id: Int,
    val leagueId: Int
)
