package com.curiozing.kotlinplay.constructorVsInit


fun main() {
    Person("Hello",23)
}
class Person {
    private var name:String? = null
    private var age:Int? = null
    constructor(name:String, age:Int){
        this.name = name
        this.age = age
        println("Constructor is Called")
    }

    init {
        println("Init is Called")
    }
}