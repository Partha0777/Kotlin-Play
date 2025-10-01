package com.curiozing.kotlinplay.delegation

class MusicDelegate {

    fun main() {
        val music = PlayMusic(Piano(), Violin())
        music.playStrings()
        music.playKeys()
    }

}


class PlayMusic(private val keysInstrument: KeysInstrument, private val stringInstrument: StringInstrument) :
    KeysInstrument by keysInstrument, StringInstrument by stringInstrument

class InPlayMusic() : Piano() {
    override fun playKeys() {
        super.playKeys()
    }
}

interface KeysInstrument {
    fun playKeys();
}


interface StringInstrument {
    fun playStrings();
}

open class Piano : KeysInstrument {
    override fun playKeys() {
        println("Play Piano")
    }

}

class Guitar : StringInstrument {

    override fun playStrings() {
        println("Play Guitar")

    }
}


class Violin : StringInstrument {

    override fun playStrings() {
        println("Play Violin")
    }
}

sealed class TestSealed() {
    class Success(data: String) : TestSealed()
    class Failure(data: String) : TestSealed()
}


