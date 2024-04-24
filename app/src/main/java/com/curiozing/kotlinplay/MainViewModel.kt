package com.curiozing.kotlinplay

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import okhttp3.ResponseBody
import java.time.Duration

class MainViewModel : ViewModel() {

    fun getDrinks() {
        viewModelScope.launch {
            val response1 = NetworkHelper.drinksService.getHotCoffee1().await()
            Log.d("Response ", "Called 1")
            val response = NetworkHelper.drinksService.getHotCoffee()
            Log.d("Response ", "Called 2")
            Log.d("Response1 ", response1.string())
            Log.d("Response ", response.string())

        }
    }

    suspend fun loadDrinks() {
        NetworkHelper.drinksService.getHotCoffee()
    }

    //RetryExample
    fun retryDrinks() {
        viewModelScope.launch {
            retry(2) {
                loadDrinks()
            }
        }
    }

    private suspend fun <T> retry(count: Int, block: suspend () -> T): T {

        repeat(count) {
            try {
                return block()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return block()
    }

    fun getAsyncColdDrinks() {
        viewModelScope.launch {
            lateinit var response: ResponseBody
            val job = launch {
                response = NetworkHelper.drinksService.getHotCoffee()
                Log.d("Response First ", response.string())
            }
            Log.d("Response Joined", "Before Joined")
            delay(2000)
            job.join()
            Log.d("Response Joined", "After Joined")

            var cun1 = async {
                NetworkHelper.drinksService.getHotCoffee1()
            }
            var cun2 = async {
                NetworkHelper.drinksService.getHotCoffee1()
            }

            awaitAll(cun1, cun2)
            Log.d("Response Final Joined", awaitAll(cun1, cun2).toString())
        }

    }


    fun getColdDrinks1() {
        viewModelScope.launch {

            val data = NetworkHelper.drinksService.getHotCoffee1().await()
            Log.d("Response Final Joined1", data.toString())

            val data1 = NetworkHelper.drinksService.getHotCoffee1().await()
            Log.d("Response Final Joined2", data1.toString())

            Log.d("Response Joined", "")
        }

    }


}