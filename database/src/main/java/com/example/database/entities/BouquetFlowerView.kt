package com.example.database.entities

import androidx.room.DatabaseView

@DatabaseView(
    """
    SELECT 
        b.id AS bouquetId,
        b.name AS bouquetName,
        f.id AS flowerId,
        f.quantity AS flowerQuantity,
        bfc.count AS flowerCount,
        (f.quantity / bfc.count) AS quantityPerBouquet
    FROM bouquets b
    INNER JOIN bouquet_flower_cross_ref bfc ON b.id = bfc.bouquetId
    INNER JOIN flowers f ON f.id = bfc.flowerId
    """
)
data class BouquetFlowerView(
    val bouquetId: Int,
    val bouquetName: String,
    val flowerId: Int,
    val flowerQuantity: Int,
    val flowerCount: Int,
    val quantityPerBouquet: Int
)
