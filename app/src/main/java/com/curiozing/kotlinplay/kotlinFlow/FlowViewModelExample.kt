package com.curiozing.kotlinplay.kotlinFlow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit.ApiHelper
import com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit.Time
import com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

class FlowViewModelExample : ViewModel() {

    val currentTime: Flow<Time> = flow {
        while (true) {
            val currentTime = ApiHelper.retrofitClient.getCurrentTime()
            emit(currentTime)
            delay(1000)
        }
    }


    //Map is the intermediate operator and asLiveData is terminal Operator
    var uiState: LiveData<UiState> = currentTime.map {
        UiState.LoadTime(it) as UiState
    }.onStart {
        emit(UiState.Loading)
    }.onCompletion {

    }.asLiveData(Dispatchers.Default)

    fun launchIn() {
        currentTime.map {
            UiState.LoadTime(it) as UiState
        }.onStart {
            emit(UiState.Loading)
        }.onCompletion {

        }.launchIn(viewModelScope)
    }


}