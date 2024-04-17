package com.curiozing.kotlinplay

import okhttp3.ResponseBody

sealed class NetworkStatus {
    class Success(response:ResponseBody): NetworkStatus()
    class Failure(errorCode:Int, errorMessage:String): NetworkStatus()
    data object Loading: NetworkStatus()

}