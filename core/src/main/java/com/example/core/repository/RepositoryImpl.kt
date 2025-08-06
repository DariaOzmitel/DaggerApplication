package com.example.core.repository

import com.example.core.network.ApiServiceCard1
import com.example.core.network.ApiServiceCard2
import com.example.feature_home.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiServiceCard1: ApiServiceCard1,
    private val apiServiceCard2: ApiServiceCard2,
) : Repository {
    override fun getCardIds1(): Flow<List<String>> = flow {
        val ids = apiServiceCard1.getIds().ids
        emit(ids)
    }.catch {
        emit(emptyList())
    }.flowOn(Dispatchers.IO)


    override fun getCardIds2(): Flow<List<String>> = flow {
        val ids = apiServiceCard2.getIds().ids
        emit(ids)
    }.catch {
        emit(emptyList())
    }.flowOn(Dispatchers.IO)
}