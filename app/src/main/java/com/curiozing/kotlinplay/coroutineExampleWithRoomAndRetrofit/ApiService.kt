package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import okhttp3.ResponseBody
import retrofit2.http.GET

interface ApiService {

    @GET("/android.json")
    suspend fun getAndroidVersion(): List<Version>

    @GET("/ios.json")
    suspend fun getIosVersion(): List<Version>

}