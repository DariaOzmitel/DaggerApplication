package com.example.core.network

import retrofit2.http.GET

interface ApiServiceCard2 {
    @GET("07d08fb00d518d7e47759e1f913b013f1ea37a40/cardId2.json")
    suspend fun getIds(): CardIdsDto
}