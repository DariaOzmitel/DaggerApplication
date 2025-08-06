package com.example.feature_home.repository

import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getCardIds1(): Flow<List<String>>
    fun getCardIds2(): Flow<List<String>>
}