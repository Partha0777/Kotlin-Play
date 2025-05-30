package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.math.BigInteger
import kotlin.system.measureTimeMillis

class AnalyserViewModel : ViewModel() {

    var totalTimeForCalculation = mutableIntStateOf(0)
    var totalTimeForStringConv = mutableIntStateOf(0)

    fun factorial(input: Int, numberOfCoroutine: Int) {

        val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Caught $throwable")
        }

        viewModelScope.launch(coroutineExceptionHandler) {
            var result = BigInteger.ZERO

            val time1 = measureTimeMillis {
                result = withContext(Dispatchers.Default) {
                    val list = subList(input, numberOfCoroutine)
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
            val time2 = measureTimeMillis {
                finalValue = convertToString(result)
            }
            totalTimeForCalculation.value = time1.toInt()
            totalTimeForStringConv.value = time2.toInt()


        }
        val job = CoroutineScope(Dispatchers.Main + coroutineExceptionHandler)

        job.launch(coroutineExceptionHandler) {

            launch {
                delay(300)
                println("data... 1")
                throw RuntimeException()

            }
            launch {
                delay(500)
                println("data... 2")

            }
            launch {
                delay(1500)
                println("data... 3")

            }
        }

        job.launch {
            launch {
                delay(1500)
                println("data... 3")

            }
        }

    }

    private suspend fun getTime() {

    }

    private suspend fun convertToString(number: BigInteger) =
        withContext(Dispatchers.Default) {
            number.toString()
        }

    private fun calculateFactorial(list: List<Int>): BigInteger {
        var bigInteger: BigInteger = BigInteger.ONE
        list.forEach {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(it.toLong()))
        }
        return bigInteger
    }

    private fun subList(value: Int, set: Int): List<List<Int>> {
        var i = 0

        val list = List(value) {
            it + 1
        }
        val data: MutableList<List<Int>> = mutableListOf()
        if (value > 1) {
            while (i < list.size) {
                val chunk = list.subList(i, minOf(i + set, list.size))
                data.add(chunk)
                i += set
            }
        } else {
            data.add(list)
        }
        return data
    }

}