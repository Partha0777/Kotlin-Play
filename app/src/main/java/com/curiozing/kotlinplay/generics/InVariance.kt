package com.curiozing.kotlinplay.generics


class Cage<in T> {
    fun put(item: T) {
        println("Putting ${item!!::class.simpleName} in the cage")
    }
}

fun putDogInCage(cage: Cage<Dog>) {
    cage.put(Dog()) // Only allows adding dogs
}

fun main() {
    val animalCage: Cage<Animal> = Cage<Animal>()
    putDogInCage(animalCage)
}

open class Car()
class Honda : Car()
class BMW : Car()

class ShowRoom<out T>(val car:T){
    fun getCar() = car
}

