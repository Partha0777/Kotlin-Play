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
    var hondaShowroom: ShowRoom<Honda> = ShowRoom(Honda())
    var bmwShowroom: ShowRoom<BMW> = ShowRoom(BMW())

    getToCarShowroom(hondaShowroom)

    val out = OutClass("string")
    val ref: OutClass<Any> = out
}

open class Car()
class Honda : Car()
class BMW : Car()

class ShowRoom<out T>(private val car: T) {
    fun getCar() = car
}

fun getToCarShowroom(showRoom: ShowRoom<Car>) {
    println(showRoom.getCar())
}


class OutClass<out T>(val value: T) {
    fun get(): T {
        return value
    }
}

val y: MyClass<Any> = MyClass<String>() // Works since String is a subtype of Any
//val z: MyClass<String> = MyClass<Any>() // Error since Any is a supertype of String

class MyClass<out T>

