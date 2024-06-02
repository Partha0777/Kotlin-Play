package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiHelper {

    private fun client(): Retrofit = Retrofit.Builder().client(OkHttpClient())
        .baseUrl("https://worldtimeapi.org/api/timezone/Asia/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()

    var retrofitClient: ApiService = client().create(ApiService::class.java)

}