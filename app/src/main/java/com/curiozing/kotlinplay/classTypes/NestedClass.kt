package com.curiozing.kotlinplay.classTypes

class OuterClass {
    private var name: String = "Ashu"

    class NestedClass {
        var description: String = "code inside nested class"
        private var id: Int = 101
        fun foo() {
            //  print("name is ${name}") // cannot access the outer class member
            println("Id is ${id}")
        }
    }
}

fun main(args: Array<String>) {
// nested class must be initialize
    println(OuterClass.NestedClass().description) // accessing property
    var obj = OuterClass.NestedClass() // object creation
    obj.foo() // access member function
}