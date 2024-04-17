package com.curiozing.kotlinplay

import okhttp3.ResponseBody

sealed class NetworkStatus {
    class Success(response:ResponseBody): NetworkStatus()
    class Failure(errorCode:Int, errorMessage:String): NetworkStatus()
    data object Loading: NetworkStatus()

}


interface DummyData{

}

class  Imple1 : DummyData {

}

class  Imple2 : DummyData {

}

class Base{

    fun getting(io:DummyData){
      when(io){
          is Imple1 -> {}
      }
    }

}