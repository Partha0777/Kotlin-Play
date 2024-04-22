package com.curiozing.kotlinplay.inlineFunctions

class InlineFunctions {
}

fun main() {
    executeInline {
        centerData()
    }

    val list = listOf(2,3,5,7)
    val result = applyToList(list = list){
        it * 8
    }

    println(result.toString())
}

fun centerData(){
    println("I'm Partha")
}

inline fun executeInline(block: () -> Unit){
    print("Hello,")
    block()
    println("Welcome!!")
}

fun <T,R> applyToList(list: List<T>, func: (T) -> R):List<R>{
    return list.map { element -> func(element) }
}


