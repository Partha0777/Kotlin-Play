package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import androidx.lifecycle.ViewModel
import java.math.BigInteger

class AnalyserViewModel : ViewModel() {
    fun calculateFactorial(min:Int, max:Int): BigInteger{
        var bigInteger:BigInteger = BigInteger.valueOf(min.toLong())
        for (i in min until max){
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i.toLong()))
        }

        return bigInteger
    }
}