package com.example.roomapplication.data.league

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "league")
data class League(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)
