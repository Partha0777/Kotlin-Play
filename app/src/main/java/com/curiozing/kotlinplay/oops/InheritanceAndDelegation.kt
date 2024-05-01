package com.curiozing.kotlinplay.oops


fun main() {
    println(Robin().fly())
}

open class Animal() {
    open fun makeSound() {

    }

    open fun run() {}
}

class Lion() : Animal() {
    override fun makeSound() {
        super.makeSound()
    }

    override fun run() {
        super.run()
    }
}

interface Birds {
    fun fly()
}

class Parrot : Birds {
    override fun fly() {
        println("it's flying dude!")
    }

}

class Robin : Birds by Parrot()