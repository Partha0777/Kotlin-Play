package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

sealed class UiState {
    data object Loading : UiState()
    data class Failure(val message: String) : UiState()
    data class Success(val response: List<Version>) : UiState()
    data class LoadTime(val response: Time) : UiState()
}