package com.curiozing.kotlinplay.delegation

import java.util.concurrent.atomic.AtomicReference

fun main() {

    var inte: AtomicReference<String>
    val headPhone = HeadPhone()
    val lowBattery = LowPowerBattery()

    val battery = SuperBattery()
    val speaker = Speaker()

    MusicPlayer(speaker, battery).play()
    MusicPlayer(speaker, battery).getCharLevel()

    val dosa = Food("dosa")
    val idly = Food("dosa")

    print("Object same? ${dosa == idly}")
}

@Synchronized
fun setData() {

}

data class Food(val name: String) {

}

interface Music {
    fun play()
    fun pause()
}

interface Battery {
    fun getCharLevel()
}

class SuperBattery : Battery {

    @Volatile
    var data = ""

    companion object {

    }

    override fun getCharLevel() {

    }
}

class LowPowerBattery : Battery {

    lateinit var data: String
    override fun getCharLevel() {
    }
}

class HeadPhone : Music {

    override fun play() {}

    override fun pause() {}

    fun pauseByButton() {}

}

class Speaker : Music {
    override fun play() {}

    override fun pause() {}
}


class MusicPlayer(music: Music, battery: Battery) : Music by music, Battery by battery


open class DeltaA {
    open val dataName = ""
    open fun methodA() {
    }
}

class DeltaB : DeltaA() {

    override var dataName = ""

    override fun methodA() {
        super.methodA()
    }
}