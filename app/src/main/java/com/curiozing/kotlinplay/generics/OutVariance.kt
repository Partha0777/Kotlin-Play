package com.curiozing.kotlinplay.generics

open class Animal {
    fun speak() = "I am an animal"
}

class Dog : Animal() {
    fun bark() = "Woof!"
}

class Box<out T>(private val item: T) {
    fun getItem(): T = item
}

fun readFromBox(box: Box<Animal>) {
    val animal: Animal = box.getItem()
    println(animal.speak())
}

fun main() {
    val dogBox: Box<Dog> = Box(Dog())
    readFromBox(dogBox)
}

