package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curiozing.kotlinplay.MyApplication
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
}