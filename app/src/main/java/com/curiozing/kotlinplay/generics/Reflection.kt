package com.curiozing.kotlinplay.generics

import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.functions
import kotlin.reflect.jvm.isAccessible

fun main() {
    val userData = User::class
    val userInstance = User()
    userData.declaredMemberProperties.forEach {
        it.isAccessible = true
        println(it.get(User()))
    }

    userData.declaredFunctions.forEach {
        if (it.name == "getUserDetails"){
            it.isAccessible = true
            println(it.call(userInstance,"Hello, I'm"))
        }
    }
}

class User{
    private val name = "Partha"
    private val city = "Chennai"

    private fun getUserDetails(greet:String):String{
        return "$greet $name - $city"
    }

}