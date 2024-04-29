package com.curiozing.kotlinplay.kotlinVsJava.nullSafety


fun main() {
    var nullableString:String? = null
    print(nullableString?.length)
    NullSafetyInJava().runMethod()
}