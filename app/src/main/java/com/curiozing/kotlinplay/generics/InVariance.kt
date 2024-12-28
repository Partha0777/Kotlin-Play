package com.curiozing.kotlinplay.generics


class SystemTech<T>(var value: T)


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

    var laptop: SystemTech<Laptop> = SystemTech(Laptop())
    laptop = SystemTech(AppleMac())

    val inClassObject: InClass<Number> = InClass()
    val ref: InClass<Int> = inClassObject

}

open class Laptop()

class AppleMac : Laptop()
class SamsungNoteBook : Laptop()

class LaptopShowRoom<in T> {
    fun get(laptop: T) {
        println("Got laptop")
    }
}

fun gotLaptopShowRoom(laptop: LaptopShowRoom<AppleMac>) {
    laptop.get(AppleMac())
}


class InClass<in T> {
    fun toString(value: T): String {
        return value.toString()
    }
}

