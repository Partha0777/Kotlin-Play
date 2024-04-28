package com.curiozing.kotlinplay.inlineFunctions

class InlineFunctionExample1 {



}

fun main() {

    val numbers = listOf(1, 2)
    multiply(numbers){
        it * 2
    }


}

private lateinit var hello:String
fun runSomething(){
    var run = hello;
}
 inline fun multiplyNumber(list: List<Int>, multiply: (Int) -> Int){
    for (item in list){
        val value = multiply(item)
        println("Value is $value")
    }
}