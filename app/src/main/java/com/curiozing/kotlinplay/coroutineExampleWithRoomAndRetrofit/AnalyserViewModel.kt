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


    fun subList(list:List<Int>,set:Int): List<List<Int>>{
        var i = 0

        var data: MutableList<List<Int>> = mutableListOf()
        while (i < list.size){
            val subList = list.subList(i, minOf(i+set,list.size))
            data.add(subList)
            i += set
        }
        return data
    }

}