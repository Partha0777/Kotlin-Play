package com.curiozing.kotlinplay.basic

fun main() {
    var data = listOf(listOf("Hello Ko", "Hey Ja"), listOf("Kotlin Wow", "Java Oh")).flatMap {
        it.flatMap {
            it.split(" ")
        }
    }

    var data2 = calculate(listOf("1", "2", "3")) {
        "$it ooo"
    }
    print("data --> $data2")
}

fun <T, R> calculate(data: List<T>, func: (T) -> R): List<R> {
    return data.map { func(it) }.toList()
}