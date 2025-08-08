package com.example.feature_home.data.repository

import com.example.core.di.Retrofit1Qualifier
import com.example.core.di.Retrofit2Qualifier
import com.example.feature_home.data.network.ApiServiceCard1
import com.example.feature_home.data.network.ApiServiceCard2
import com.example.feature_home.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    @Retrofit1Qualifier
    private val retrofit1: Retrofit,
    @Retrofit2Qualifier
    private val retrofit2: Retrofit,
) : Repository {
    override fun getCardIds1(): Flow<List<String>> = flow {
        val ids = retrofit1.create(ApiServiceCard1::class.java).getIds().ids
        emit(ids)
    }.catch {
        emit(emptyList())
    }.flowOn(Dispatchers.IO)


    override fun getCardIds2(): Flow<List<String>> = flow {
        val ids = retrofit2.create(ApiServiceCard2::class.java).getIds().ids
        emit(ids)
    }.catch {
        emit(emptyList())
    }.flowOn(Dispatchers.IO)
}