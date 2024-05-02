package com.curiozing.kotlinplay.delegation


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

interface Gear{
    fun changeGear();

}

interface Steering{

    fun moveSteering();
}

class AutoGear : Gear{
    override fun changeGear() {
        TODO("Not yet implemented")
    }


}

class ManualGear: Gear{
    override fun changeGear() {
        TODO("Not yet implemented")
    }


}

class PowerSteering():Steering{
    override fun moveSteering() {
        TODO("Not yet implemented")
    }

}

class NormalSteering():Steering{
    override fun moveSteering() {
        TODO("Not yet implemented")
    }

}

class Car(val steering: Steering, val gear: Gear) : Steering by steering, Gear by gear{

    fun callMove(){
        steering.moveSteering()
    }

}