package com.curiozing.kotlinplay

import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Response

import retrofit2.http.GET


interface Drinks {

    @GET("/coffee/hot")
    suspend fun getHotCoffee(): ResponseBody

    @GET("/coffee/hotrere")
    fun getHotCoffee1(): Deferred<ResponseBody>

}