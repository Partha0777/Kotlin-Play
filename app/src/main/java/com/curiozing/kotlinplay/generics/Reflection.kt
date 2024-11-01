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

    println( createDynamicInstance("com.curiozing.kotlinplay.generics.Product"))

}

class User{
    private val name = "Partha"
    private val city = "Chennai"

    private fun getUserDetails(greet:String):String{
        return "$greet $name - $city"
    }

}

data class Product(val id:Int,val name:String)

fun createDynamicInstance(className:String): Any?{
    return try {
        val kClass = Class.forName(className).kotlin
        kClass.constructors.firstOrNull()?.call(1,"Laptop")

    }catch (e:Exception){
        e.printStackTrace()
    }
}