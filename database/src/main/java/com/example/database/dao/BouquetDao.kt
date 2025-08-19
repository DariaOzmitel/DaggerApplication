package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.entities.AvailableBouquets
import com.example.database.entities.Bouquet
import com.example.database.entities.BouquetFlowerCrossRef
import com.example.database.entities.BouquetWithFlowers
import com.example.database.entities.FlowersWithCount

@Dao
interface BouquetDao {
    @Query("SELECT * FROM bouquets")
    suspend fun getAllBouquets(): List<BouquetWithFlowers>

    @Query("SELECT flowerId, flowerQuantity - flowerCount AS count  FROM BouquetFlowerView WHERE bouquetId = :bouquetId")
    suspend fun getRemainingFlowersAfterBuyingBouquet(bouquetId: Int): List<FlowersWithCount>

    @Query(
        """
    SELECT 
        bouquetId,
        bouquetName,
        MIN(quantityPerBouquet) AS available
    FROM BouquetFlowerView
    GROUP BY bouquetId, bouquetName
    HAVING MIN(quantityPerBouquet) > 0
"""
    )
    suspend fun getAvailableBouquets(): List<AvailableBouquets>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBouquet(bouquet: List<Bouquet>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBouquetFlowers(crossRefs: List<BouquetFlowerCrossRef>)
}