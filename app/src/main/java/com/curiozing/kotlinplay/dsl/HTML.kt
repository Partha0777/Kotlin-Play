package com.curiozing.kotlinplay.dsl

// Define the structure of the DSL
class HTML {
    private val elements = mutableListOf<Element>()

    fun body(init: Body.() -> Unit) {
        val body = Body()
        body.init() // Call the lambda with the receiver (Body)
        elements.add(body)
    }

    override fun toString() = elements.joinToString("\n")
}

abstract class Element(val name: String) {
    protected val children = mutableListOf<Element>()
    override fun toString() = "<$name>\n${children.joinToString("\n")}\n</$name>"
}

class Body : Element("body") {
    fun p(init: P.() -> Unit) {
        val paragraph = P()
        paragraph.init()
        children.add(paragraph)
    }
}

class P : Element("p")

// Usage of the DSL
fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init() // Initialize the HTML structure
    return html
}

val names: List<String> = listOf("Alice", "Bob", "Charlie")
typealias ErrorHandler = (Int) -> String

fun main() {
    val document = html {
        body {
            p {
                // Paragraph content can be added here
            }
        }
    }

    println(document)


    val handleNetworkError: ErrorHandler = { code ->
        when (code) {
            404 -> "Not Found"
            500 -> "Internal Server Error"
            else -> "Unknown Error"
        }
    }

    println(handleNetworkError(4904)) // Output: Not Found
}
