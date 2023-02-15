package com.example.roomapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "league_table")
data class League(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)
