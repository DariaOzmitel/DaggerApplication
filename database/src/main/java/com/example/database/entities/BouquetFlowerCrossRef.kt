package com.example.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "bouquet_flower_cross_ref",
    primaryKeys = ["bouquetId", "flowerId"],
    foreignKeys = [
        ForeignKey(entity = Bouquet::class, parentColumns = ["id"], childColumns = ["bouquetId"]),
        ForeignKey(entity = Flower::class, parentColumns = ["id"], childColumns = ["flowerId"])
    ]
)
data class BouquetFlowerCrossRef(
    val bouquetId: Int,
    val flowerId: Int,
    val count: Int
)