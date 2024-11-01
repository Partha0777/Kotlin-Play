package com.curiozing.kotlinplay.generics

import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

fun main() {
    val userData = User::class

    userData.declaredMemberProperties.forEach {
        it.isAccessible = true
        println(it.get(User()))
    }
}

class User{
    private val name = "Partha"
    private val city = "Chennai"

    fun getUserDetails():String{
        return "$name - $city"
    }

}