package com.curiozing.kotlinplay.basic

fun main() {
    val  (name, city) = Person("Partha","Chennai")
    println(name)


    val (data1, data2) = listOf("Kotlin", "Java", "C", "C++")
    println(data2)


}
data class Person(
    val name:String,
    val city:String
)