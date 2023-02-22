package com.example.roomapplication.data.game

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.roomapplication.data.league.League
import com.example.roomapplication.data.team.Team
import java.util.Date

@Entity(
    tableName = "game",
    foreignKeys = [
        ForeignKey(
            entity = League::class,
            parentColumns = ["id"],
            childColumns = ["leagueId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Team::class,
            parentColumns = ["name"],
            childColumns = ["team1"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Team::class,
            parentColumns = ["name"],
            childColumns = ["team2"],
            onDelete = ForeignKey.CASCADE
        ),
    ]
)
data class Game(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val team1: String,
    val team2: String,
    val leagueId: Int
)
