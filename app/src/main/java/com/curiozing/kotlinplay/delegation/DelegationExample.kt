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
        TODO("Not yet implemented")
    }

    override fun pause() {
        TODO("Not yet implemented")
    }

    fun pauseByButton() {

    }

}

class Speaker : Music {
    override fun play() {
        TODO("Not yet implemented")
    }

    override fun pause() {
        TODO("Not yet implemented")
    }

}

class MusicPlayer(music: Music) : Music by music