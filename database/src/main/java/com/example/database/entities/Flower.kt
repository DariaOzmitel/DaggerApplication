package com.example.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flowers")
data class Flower(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val quantity: Int
)

data class FlowersWithCount(
    val flowerId: Int,
    val count: Int
)
