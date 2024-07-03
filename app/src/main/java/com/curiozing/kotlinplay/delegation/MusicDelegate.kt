package com.curiozing.kotlinplay.delegation

class MusicDelegate {

    fun main(){
        val music = PlayMusic(Piano(),Violin())
        music.playStrings()
        music.playKeys()
    }

}


class PlayMusic(val keysInstrument: KeysInstrument, val stringInstrument: StringInstrument) : KeysInstrument by keysInstrument, StringInstrument by stringInstrument



interface KeysInstrument{
    fun playKeys();
}


interface StringInstrument{
    fun playStrings();
}

open class Piano : KeysInstrument{
    override fun playKeys() {
        println("Play Piano")
    }

}

class Guitar : StringInstrument{

    override fun playStrings() {
        println("Play Guitar")

    }
}


class Violin : StringInstrument{

    override fun playStrings() {
        println("Play Violin")
    }
}


