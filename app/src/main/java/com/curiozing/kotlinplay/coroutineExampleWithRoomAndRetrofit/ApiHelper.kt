package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiHelper {

    var retrofit = Retrofit.Builder().client(OkHttpClient())
        .baseUrl("https://kotlin-play-default-rtdb.firebaseio.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()


    var retrofitClient = retrofit.create(ApiService::class.java)

}