package com.curiozing.kotlinplay.kotlinVsJava.nullSafety


fun main() {
    var nullableString:String? = null
    println(nullableString?.length)
    println("300".priceWithCurrency())
    NullSafetyInJava().runMethod()
}

fun String.priceWithCurrency() :String{
    return "$$this"
}