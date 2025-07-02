package com.curiozing.kotlinplay.kotlinFlow


fun main() {

    val list = mutableListOf(19, 8, 2, 45, 7, 3)
    val temp = mutableListOf<Int>()

    list.forEach {
        var i = 0
        while (temp.size > i && it > temp[i]) {
            i++
        }
        temp.add(i, it)
    }

    print(temp)
}
