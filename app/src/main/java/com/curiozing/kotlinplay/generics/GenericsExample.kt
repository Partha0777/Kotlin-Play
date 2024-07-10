package com.curiozing.kotlinplay.generics


fun main() {
    findTheCharCounts("Parthasarathi")
    val intData = listOf(1, 2, 3, 4, 5, 6, 7)
    val stringData = listOf("Kan", "Partha", "Sarathy", "Curio")
    val doubleData = listOf(2.4, 2.5, 3.4, 5.5)

    GenericsExample(doubleData).find(5.5) {
        println("Found $it")
    }

    val data = genericFunc(intData) {
        it * 2
    }
    println("Data is $data")
}

fun <T, R> genericFunc(list: List<T>, func: (T) -> R): List<R> {
    return list.map { e -> func(e) }
}

fun findTheCharCounts(data: String){

    val charCounts = mutableMapOf<String,Int>()

    data.trim().lowercase().forEach {
        if (!it.isWhitespace()){
            charCounts[it.toString()] = charCounts.getOrDefault(it.toString(),0)+1
        }
    }

    println(charCounts)

}


class GenericsExample<T>(var list: List<T>) {

    fun find(value: T, found: (T) -> Unit) {
        val data = list.filter {
            it == value
        }
        found(data.first())
    }

}