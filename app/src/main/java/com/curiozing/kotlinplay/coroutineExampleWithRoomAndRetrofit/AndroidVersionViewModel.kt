package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curiozing.kotlinplay.MyApplication
import kotlinx.coroutines.launch

class AndroidVersionViewModel : ViewModel() {

    fun getAndroidVersions(){
        val db = (MyApplication.getContext() as MyApplication).getAppDatabase()
        viewModelScope.launch {
            val data = ApiHelper.retrofitClient.getAndroidVersion()
            db.versionDAO().insertAllVersion(data)
           Log.d("response -->", data.toString())
        }

    }
}