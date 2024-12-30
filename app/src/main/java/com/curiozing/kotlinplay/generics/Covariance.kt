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
    val hondaShowroom: ShowRoom<Honda> = ShowRoom(Honda())
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


//Simple example for both In and Out
//Covariance
val a: MyClassCv<Any> = MyClassCv<String>() // Works since String is a subtype of Any

//val b: MyClassCv<String> = MyClassCv<Any>() // Error since Any is a supertype of String
class MyClassCv<out T>


//Contracovariance
//val y: MyClassCt<Any> = MyClassCt<String>() // Error since String is a subtype of Any
val z: MyClassCt<String> = MyClassCt<Any>() // Works since Any is a Super type of String

class MyClassCt<in T>

