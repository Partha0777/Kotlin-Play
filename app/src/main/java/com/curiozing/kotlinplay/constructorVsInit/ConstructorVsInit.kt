package com.curiozing.kotlinplay.constructorVsInit


fun main() {
   // Person("Hello",23)
    User("Hello",23)
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
        println("Init 1 is Called")
    }
    init {
        println("Init 2 is Called")
    }
}


class User(val name: String) {
    var age: Int = 0

    // Init block will execute before Secondary Constructor.
    init {
        println("Init block called for $name")
    }

    // Secondary Constructor – Runs after the primary constructor and all init blocks.
    constructor(name: String, age: Int) : this(name) {
        println("Secondary constructor called")
        this.age = age
    }
}