package com.example.feature_home.domain.usecases

import com.example.feature_home.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCardIdsFromServer1UseCase @Inject constructor(
    private val repository: Repository
) {
    fun invoke(): Flow<List<String>> {
        return repository.getCardIds1()
    }
}