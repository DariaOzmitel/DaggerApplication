package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.entities.Flower

@Dao
interface FlowerDao {
    @Query("SELECT * FROM flowers")
    suspend fun getAllFlowers(): List<Flower>

    @Query("UPDATE flowers SET quantity = :newQuantity WHERE id = :flowerId")
    suspend fun updateQuantity(flowerId: Int, newQuantity: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlowers(flowers: List<Flower>)
}