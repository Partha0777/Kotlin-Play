package com.curiozing.kotlinplay.basic

fun main() {

    val list = listOf(1,2,3,4,5)
    val list1 = listOf("c","d","e","f","g","a","b")

    for (i in list){
        println(i)
    }

    for (i in 3 downTo 1){
        println("downTo $i")
    }


    for(i in 0..11 step 2){
        println("step $i")
    }

    list1.forEach {
        println(it)
    }

}