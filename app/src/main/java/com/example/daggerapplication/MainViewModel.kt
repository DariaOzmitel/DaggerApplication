package com.example.daggerapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feature_home.usecases.GetCardIdsFromServer1UseCase
import com.example.feature_home.usecases.GetCardIdsFromServer2UseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getCardIdsFromServer1UseCase: GetCardIdsFromServer1UseCase,
    private val getCardIdsFromServer2UseCase: GetCardIdsFromServer2UseCase,
) : ViewModel() {
    private val mainStateMutable =
        MutableStateFlow(0)
    val mainState: StateFlow<Int> = mainStateMutable

    fun getCardList1() {
        viewModelScope.launch {
            getCardIdsFromServer1UseCase.invoke().collect { cardIdList ->
                mainStateMutable.value = cardIdList.size
            }
        }
    }

    fun getCardList2() {
        viewModelScope.launch {
            getCardIdsFromServer2UseCase.invoke().collect { cardIdList ->
                mainStateMutable.value = cardIdList.size
            }
        }
    }
}