package com.curiozing.kotlinplay.classTypes

class OuterClassIn {
    private var name: String = "Ashu"

    inner class InnerClass {
        var description: String = "code inside inner class"
        private var id: Int = 101
        fun foo() {
            println("name is ${name}") // access the outer class member even private
            println("Id is ${id}")
        }
    }
}

fun main(args: Array<String>) {
    println(OuterClassIn().InnerClass().description) // accessing property
    var obj = OuterClassIn().InnerClass() // object creation
    obj.foo() // access member function

}