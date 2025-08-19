package com.example.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bouquets")
data class Bouquet(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val decoration: String? = null
)

data class AvailableBouquets(
    val bouquetId: Int,
    val bouquetName: String,
    val available: Int
)