package com.curiozing.kotlinplay

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkHelper {

    val baseUrl = "https://api.sampleapis.com/"
    private fun getClient(): Retrofit {
        return Retrofit.Builder().client(OkHttpClient()).baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()
    }

    var drinksService = getClient().create(Drinks::class.java)

}