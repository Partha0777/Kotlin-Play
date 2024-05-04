package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

sealed class UiState {
    data object Loading : UiState()
    data class Failure(val message:String) : UiState()
    data class Success(val response:Any) : UiState()
}