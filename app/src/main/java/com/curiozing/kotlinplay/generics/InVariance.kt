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

    val genericLaptop: LaptopShowRoom<Laptop> = LaptopShowRoom<Laptop>()
    gotLaptopShowRoom(genericLaptop)
}

open class Laptop()

class AppleMac : Laptop()
class SamsungNoteBook : Laptop()

class LaptopShowRoom<in T>{
    fun get(laptop:T){
        println("Got laptop")
    }
}

fun gotLaptopShowRoom(laptop:LaptopShowRoom<AppleMac>) {
    laptop.get(AppleMac())
}

