package com.example.feature_home.usecases

import com.example.feature_home.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCardIdsFromServer2UseCase @Inject constructor(
    private val repository: Repository
) {
    fun invoke(): Flow<List<String>> {
        return repository.getCardIds2()
    }
}