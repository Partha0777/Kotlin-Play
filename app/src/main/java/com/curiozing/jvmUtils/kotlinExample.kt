package com.curiozing.jvmUtils


class TestKotlin() {

    companion object {
        @JvmStatic
        val dataExample = "Test";
    }

}

@JvmOverloads
fun testMethod(data: String = "Example data") {
}

data class Student(@JvmField var name: String, var age: Int)