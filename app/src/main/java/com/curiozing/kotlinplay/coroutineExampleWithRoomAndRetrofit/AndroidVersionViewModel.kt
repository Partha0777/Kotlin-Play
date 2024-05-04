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
           var data = db.versionDAO().getVersions()
            if (data.isNotEmpty()){
                uiState.value = UiState.Success(data)
            }
            data = ApiHelper.retrofitClient.getAndroidVersion()
            db.versionDAO().insertAllVersion(data)
            uiState.value = UiState.Success(data)
        }

    }
}