package com.curiozing.kotlinplay

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    fun getDrinks(){
        viewModelScope.launch {
            val response1 = NetworkHelper.drinksService.getHotCoffee1().await()
            val response = NetworkHelper.drinksService.getHotCoffee()
            Log.d("Response ", response.string())
            Log.d("Response1 ", response1.string())

        }
    }

}