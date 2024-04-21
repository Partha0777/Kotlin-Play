package com.curiozing.kotlinplay.sealedClass

sealed class Example {
    class sub1: Example()
    object sub2:Example()
}

