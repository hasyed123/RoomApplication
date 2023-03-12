package com.example.roomapplication.data.team

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.roomapplication.data.league.LeagueEntity

@Entity(
    tableName = "team",
    foreignKeys = [
        ForeignKey(
            entity = LeagueEntity::class,
            parentColumns = ["id"],
            childColumns = ["leagueId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["name", "leagueId"], unique = true)]
)
data class TeamEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val leagueId: Int,
    val wins: Int,
    val losses: Int,
    val ties: Int
)
