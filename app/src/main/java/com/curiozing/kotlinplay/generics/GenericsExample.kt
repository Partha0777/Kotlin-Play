package com.curiozing.kotlinplay.generics


fun main() {

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

class GenericsExample<T>(var list: List<T>) {

    fun find(value: T, found: (T) -> Unit) {
        val data = list.filter {
            it == value
        }
        found(data.first())
    }

}