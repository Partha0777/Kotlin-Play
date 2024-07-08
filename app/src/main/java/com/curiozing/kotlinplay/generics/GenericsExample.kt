package com.curiozing.kotlinplay.generics


fun main() {



}
class GenericsExample<T>(var list:List<T>) {

    fun find(value: T, found : (T) -> Unit ){
        val data = list.filter {
            it == value
        }
        found(data.first())
    }

}