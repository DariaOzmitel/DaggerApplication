package com.example.database.entities

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class BouquetWithFlowers(
    @Embedded val bouquet: Bouquet,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = BouquetFlowerCrossRef::class,
            parentColumn = "bouquetId",
            entityColumn = "flowerId"
        )
    )
    val flowers: List<Flower>
)

