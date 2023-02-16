package com.example.roomapplication.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "team_table",
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
