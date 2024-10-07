package com.curiozing.kotlinplay.functions

fun main() {
    var person:Person? = null
    person = Person("Kan", 29, 17782)

    val letExample = person?.let {
        it.age * 4
    }

    val runExample = person.run {
        name = "Gus"
        this
    }
    print(runExample  )

    val alsoExample = person.also {
        it.age = 34
    }

    val applyExample = person.apply {
        name = "Kou Kou"
    }

    val withExample = with(person){
        name.length
    }
}

data class Person(
    var name: String,
    var age: Int,
    var id: Long
)

class Fuss{
    var person: Person? = null

    fun hello(){
        val letExample = person?.let {
            it.age * 4
        }
    }
}