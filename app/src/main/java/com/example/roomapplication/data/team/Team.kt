package com.example.roomapplication.data.team

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.roomapplication.data.league.League

@Entity(
    tableName = "team",
    foreignKeys = [
        ForeignKey(
            entity = League::class,
            parentColumns = ["id"],
            childColumns = ["leagueId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Team(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    val leagueId: Int
)
