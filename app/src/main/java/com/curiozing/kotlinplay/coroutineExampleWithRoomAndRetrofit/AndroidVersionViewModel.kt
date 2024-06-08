package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.curiozing.kotlinplay.MyApplication
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class AndroidVersionViewModel : ViewModel() {

    private var uiState = mutableStateOf<UiState>(UiState.Loading)

    var getUiState = uiState

    fun getAndroidVersions() {
        val db = (MyApplication.getContext() as MyApplication).getAppDatabase()
        viewModelScope.launch {
            val localData = db.versionDAO().getVersions().toMutableList()
            when {
                localData.isNotEmpty() -> {
                    uiState.value = UiState.Success(localData)
                }
            }
            val remoteData = ApiHelper.retrofitClient.getAndroidVersion()

            remoteData.forEachIndexed { index, version ->
                if (localData.getOrNull(index) == null) {
                    db.versionDAO().insertVersion(version)
                } else {
                    remoteData[index].id = localData[index].id
                }
            }

            when {
                localData.isNotEmpty() -> {
                    db.versionDAO().updateAllVersions(remoteData)
                }

                else -> {
                    db.versionDAO().insertAllVersion(remoteData)
                }
            }

            uiState.value = UiState.Success(remoteData)
        }

    }

    fun getCurrentTime() {

/*
        viewModelScope.launch {


          */
/*      while(true){
                    val currentTime = ApiHelper.retrofitClient.getCurrentTime()
                    uiState.value = UiState.LoadTime(currentTime)
                    delay(500)

                }


            println("Hello it's called....")*//*


            val currentTime:Flow<Time> = flow {
                while (true) {
                    val currentTime = ApiHelper.retrofitClient.getCurrentTime()
                    emit(currentTime)
                    delay(1000)
                }
            }


            currentTime.collect{
                uiState.value = UiState.LoadTime(it)
            }

        }
*/

        val currentTime:Flow<Time> = flow {
            while (true) {
                val currentTime = ApiHelper.retrofitClient.getCurrentTime()
                emit(currentTime)
                delay(1000)
            }
        }

        currentTime
            .onEach {
                uiState.value = UiState.LoadTime(it)
            }
            .launchIn(viewModelScope)

        var currentTimeLive: LiveData<UiState> = currentTime.map {
            UiState.LoadTime(it)
        }.onStart {

        }.onCompletion {

        }.asLiveData()
    }


}