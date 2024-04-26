package com.curiozing.kotlinplay.inlineFunctions

class InlineFunctions

fun main() {
    executeInline {
        centerData()
    }

    val list = listOf(2, 3, 5, 7)
    val result = applyToList(list = list) {
        it * 2
    }

    println(result.toString())

    applyUnit("woo") {
        print("No End!")
    }

    val numbers = listOf(1, 2, 3, 4, 5, 6)
    filterList(list = numbers) {
        it % 2 == 0
    }

}


fun centerData() {
    println("I'm Partha")
}

inline fun executeInline(block: () -> Unit) {
    print("Hello,")
    block()
    println("Welcome!!")
}

fun <T, R> applyToList(list: List<T>, func: (T) -> R): List<R> {
    return list.map { element -> func(element) }
}

fun <T> applyUnit(data: T, block: () -> Unit) {
    println(data)
    block()

}

inline fun filterList(list: List<Int>, filter: (Int) -> Boolean) {
    val filterList = mutableListOf<Int>()
    for (item in list) {
        if (filter(item)) {
            filterList.add(item)
        }
    }

    println(filterList)
}

