package com.curiozing.kotlinplay.basic

fun main() {
    val  (name, city) = Person("Partha","Chennai")
    println(name)



}
data class Person(
    val name:String,
    val city:String
)