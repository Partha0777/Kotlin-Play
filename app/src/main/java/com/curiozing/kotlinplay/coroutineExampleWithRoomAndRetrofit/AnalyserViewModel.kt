package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigInteger
import kotlin.system.measureTimeMillis

class AnalyserViewModel : ViewModel() {




    fun factorial(input:Int,numberOfCoroutine:Int){

        viewModelScope.launch {
            val list = subList(input, numberOfCoroutine)
            var result = BigInteger.ZERO
            var time1 = measureTimeMillis {
                result =  withContext(Dispatchers.Default){
                    list.map {
                        async {
                            calculateFactorial(it)
                        }
                    }
                }.awaitAll().fold(BigInteger.ONE) { acc, element ->
                    acc.multiply(element)
                }

            }
            var finalValue = ""
            var time2 = measureTimeMillis {
               finalValue = convertToString(result)
            }
            println("Data $finalValue")
            println("Data time ${time1 + time2}")
        }
    }

    private suspend fun convertToString(number: BigInteger) =
        withContext(Dispatchers.Default){
            number.toString()
        }

    private fun calculateFactorial(list: List<Int>): BigInteger {
        var bigInteger: BigInteger = BigInteger.ONE
        list.forEach {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(it.toLong()))
        }
        return bigInteger
    }

    fun subList(value: Int,set:Int): List<List<Int>>{
        var i = 0
        val list = mutableListOf<Int>()
        for (n in 0 until value){
            list.add(n+1)
        }
        val data: MutableList<List<Int>> = mutableListOf()
        while (i < list.size){
            val chunk = list.subList(i, minOf(i+set,list.size))
            data.add(chunk)
            i += set
        }
        return data
    }

}