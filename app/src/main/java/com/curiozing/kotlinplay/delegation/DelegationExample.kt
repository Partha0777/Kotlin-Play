package com.curiozing.kotlinplay.delegation

fun main() {

    val headPhone = HeadPhone()
    val speaker = Speaker()
    MusicPlayer(headPhone).play()
}

interface Music {
    fun play()
    fun pause()
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

class MusicPlayer(music: Music) : Music by music