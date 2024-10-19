package com.curiozing.kotlinplay.dsl


class Home {
    fun p(name: String) {
        println("Hello $name")
    }
}


fun main() {
    dodo {
        p("Partha")
    }
}

fun dodo(init: Home.() -> Unit) {
    val home = Home()
    home.init()
}
