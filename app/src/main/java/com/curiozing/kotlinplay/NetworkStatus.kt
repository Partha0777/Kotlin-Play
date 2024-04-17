package com.curiozing.kotlinplay

import okhttp3.ResponseBody

sealed class NetworkStatus {
    class Success(response:ResponseBody): NetworkStatus(){
        fun well(){

        }
    }
    class Failure(errorCode:Int, errorMessage:String): NetworkStatus(){
        fun hello(){

        }
    }
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

    fun getting(io:NetworkStatus){
        (
            when (io) {
                is NetworkStatus.Failure ->{
                    io.hello()
                }
                is NetworkStatus.Success ->{
                    io.well()
                }
                is NetworkStatus.Loading ->{

                }
            }
        )
    }

}