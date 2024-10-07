package com.curiozing.kotlinplay.functions

fun main() {
    var person: Person? = null
    person = Person("Kan", 29, 17782)

    val letExample = person?.let {
        it.age * 4
    }
    print("let - $letExample")


    val runExample = person.run {
        name = "Gus"
        this
    }
    print("run - $runExample")


    val alsoExample = person.also {
        it.age = 34
    }
    print("also - $alsoExample")


    val applyExample = person.apply {
        name = "Kou Kou"
    }
    print("apply - $applyExample")


    val withExample = with(person) {
        name.length
    }
    print("with - $withExample")

}

data class Person(
    var name: String,
    var age: Int,
    var id: Long
)

class Fuss {
    var person: Person? = null

    fun hello() {
        val letExample = person?.let {
            it.age * 4
        }
    }
}