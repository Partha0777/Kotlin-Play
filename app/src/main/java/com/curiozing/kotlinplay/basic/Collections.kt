package com.curiozing.kotlinplay.basic

fun main() {

    //map
    val numbers = listOf(1, 2, 3)
    val squared = numbers.map { it * it }
    println(squared)
    // Output: [1, 4, 9]


    //mapIndexed
    val words = listOf("a", "b", "c")
    val indexedWords = words.mapIndexed { index, value -> "$index: $value" }
    println(indexedWords)
    // Output: [0: a, 1: b, 2: c]


    //mapNotNull
    val texts = listOf("Kotlin", "", "Programming", null, "Language")
    val nonEmptyTexts = texts.mapNotNull { it?.takeIf { it.isNotEmpty() } }
    println(nonEmptyTexts)
    // Output: [Kotlin,  , Programming, Language]


    val numbers1 = listOf(1, 2, 3)
    val evenOrNull = numbers1.mapNotNull { if (it % 2 == 0) it else null }
    println(evenOrNull)
    // Output: [2]

    //mapIndexedNotNull
    val indexedEvenLength = words.mapIndexedNotNull { index, value ->
        if (value.length % 2 == 0) "$index: $value" else null
    }
    println(indexedEvenLength)
    // Output: [1: bb]


    //flatMap
    val nestedList = listOf(1..2, 3..4)
    val flatList = nestedList.flatMap { it -> it.map { it * 2 } }
    println(flatList)
    // Output: [1, 2, 3, 4]


    //flatten
    val flattenList = nestedList.flatten()
    println(flattenList)
    // Output: [1, 2, 3, 4]


    //filter
    val filterList = listOf(1, 2, 3, 4).filter { it % 2 == 0 }
    println(filterList)


    //filterNotList
    val filterNotList = listOf(1, 2, 3, 4).filterNot { it % 2 == 0 }
    println(filterNotList)


    //filterIsInstance
    val mixedList = listOf(1, "two", 3.0, "four").filterIsInstance<String>()
    println(mixedList)


    //filterIndexed
    val filterIndex = listOf(1, 2, 3, 4).filterIndexed { index, element -> index + element == 5 }
    println(filterIndex)


    //fold
    val fold = listOf(1, 2, 3, 4).fold(0) { total, next ->
        total + next
    }
    println(fold)


    //reduce
    val reduce = listOf(1, 2, 3).reduce { total, next ->
        total + next
    }
    println(reduce)


    //groupBy
    val groupBy = listOf("Jack", "Robin", "John", "Rock").groupBy {
        it.first()
    }
    println(groupBy)


    //partition
    val partition = listOf(1, 2, 3, 4).partition { it % 2 == 0 }
    println(partition)

}

