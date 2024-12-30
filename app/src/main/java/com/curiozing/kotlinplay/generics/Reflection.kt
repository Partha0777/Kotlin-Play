package com.curiozing.kotlinplay.generics

import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.jvm.isAccessible

fun main() {
    val userData = User::class
    val userInstance = User()
    userData.declaredMemberProperties.forEach {
        it.isAccessible = true
        println(it.get(User()))
    }
    // Jus think about "getUserDetails" come from API and also we can have some different value in features
    // Analytics
    val dynamicAnalytics = "googleAnalytics"
    val dynamicMethod = userData.declaredFunctions.find { it.name == dynamicAnalytics }
    println(dynamicMethod?.call(userInstance, "Hello, I'm"))
    // if we not not using reflection we need to do below if else condition for call this method dynamically and also it make more complex
    /* if(dynamicAnalytics == "googleAnalytics"){
         userInstance.googleAnalytics("")
     }else if (dynamicAnalytics == "flurryAnalytics"){
         userInstance.flurryAnalytics("")
     }else if(dynamicAnalytics == "fbAnalytics"){
         userInstance.fbAnalytics("")
     }
     */
    println(createDynamicInstance("com.curiozing.kotlinplay.generics.Product"))

}

class User {
    private val name = "Partha"
    private val city = "Chennai"

    fun googleAnalytics(greet: String): String {
        return "googleAnalytics - $greet $name - $city"
    }

    fun flurryAnalytics(greet: String): String {
        return "flurryAnalytics - $greet $name - $city"
    }

    fun fbAnalytics(greet: String): String {
        return "fbAnalytics - $greet $name - $city"
    }

    fun dataDogAnalytics(greet: String): String {
        return "dataDogAnalytics - $greet $name - $city"
    }

}

data class Product(val id: Int, val name: String)

fun createDynamicInstance(className: String): Any? {
    return try {
        val kClass = Class.forName(className).kotlin
        kClass.constructors.firstOrNull()?.call(1, "Laptop")

    } catch (e: Exception) {
        e.printStackTrace()
    }
}