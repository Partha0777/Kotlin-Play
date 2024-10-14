package com.curiozing.kotlinplay.basic

fun main() {
    val (name, city) = Person("Partha", "Chennai")
    println(name)

    val (data1, data2) = listOf("Kotlin", "Java", "C", "C++")
    println(data2)

    val map = mapOf("key1" to "value1", "key2" to "value2")
    for ((key, value) in map) {
        println("$key - $value")
    }
}

data class Person(val name: String, val city: String)