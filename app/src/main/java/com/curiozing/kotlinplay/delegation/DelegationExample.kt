package com.curiozing.kotlinplay.delegation

fun main() {

    val headPhone = HeadPhone()
    val lowBattery = LowPowerBattery()
    val battery = SuperBattery()
    val speaker = Speaker()

    MusicPlayer(speaker, battery).play()
    MusicPlayer(speaker, battery).getCharLevel()
}

interface Music {
    fun play()
    fun pause()
}

interface Battery {
    fun getCharLevel()
}

class SuperBattery : Battery {
    override fun getCharLevel() {
    }
}

class LowPowerBattery : Battery {
    override fun getCharLevel() {
    }
}


class HeadPhone : Music {

    override fun play() {
    }

    override fun pause() {
    }

    fun pauseByButton() {

    }

}

class Speaker : Music {
    override fun play() {
    }

    override fun pause() {
    }

}

class MusicPlayer(music: Music, battery: Battery) : Music by music, Battery by battery