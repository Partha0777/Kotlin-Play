package com.curiozing.kotlinplay.delegation

fun main() {

    val file = "demo.mp4"

    val downloader = MediaDownloader(file)
    val player = MediaPlayer(file)

    val mediaFile = MediaFile(downloader = downloader, player = player)

    mediaFile.download()
    mediaFile.play()

}

// Delegations

/*class MediaFile1(private val downloader: Downloader, private val player: Player):Downloader,Player {
    override fun download() {
        downloader.download()
    }

    override fun play() {
       player.play()
    }

}*/

class MediaFile(private val downloader: Downloader, private val player: Player) :
    Downloader by downloader, Player by player

interface Downloader {
    fun download()
}

interface Player {
    fun play()
}


class MediaDownloader(var file: String) : Downloader {
    override fun download() {
        println("$file Downloading....")
    }

}

class MediaPlayer(var file: String) : Player {
    override fun play() {
        println("$file Playing....")
    }

}

sealed class SealedExample {
    data object Loading : SealedExample()

    data object Success : SealedExample()
}