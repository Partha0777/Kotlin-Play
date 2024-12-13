package com.curiozing.kotlinplay.generics

class Box<T>(val content:T)

fun main(){
    val intType = Box(12)
    val stringType = Box("Hello")

    println(genericFunction("hello"))
}

fun <T> genericFunction(data:T):T{
    return data
}