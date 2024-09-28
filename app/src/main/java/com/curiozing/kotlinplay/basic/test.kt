package com.curiozing.kotlinplay.basic

fun main() {
   var data = listOf(listOf("Hello Ko", "Hey Ja"), listOf("Kotlin Wow", "Java Oh")).flatMap {
       it.flatMap{
           it.split(" ")
       }
   }
        print("data --> $data")
}