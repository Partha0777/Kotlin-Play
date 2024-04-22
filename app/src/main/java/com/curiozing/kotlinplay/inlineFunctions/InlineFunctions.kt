package com.curiozing.kotlinplay.inlineFunctions

class InlineFunctions {
}

fun main() {
    executeInline {
        centerData()
    }
}

fun centerData(){
    println("I'm Partha")
}

inline fun executeInline(block: () -> Unit){
    print("Hello,")
    block()
    print("Welcome!!")
}


