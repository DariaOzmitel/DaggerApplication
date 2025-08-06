package com.example.core.network

import retrofit2.http.GET

interface ApiServiceCard1 {
    @GET("c0c469feb00a91394b06bd39d37a228b527c100b/cardId1.json")
    suspend fun getIds(): CardIdsDto
}