package com.curiozing.kotlinplay.basic

import android.util.Log
import java.util.concurrent.Executors


fun main() {


    val executorService = Executors.newFixedThreadPool(4) // Pool with 4 threads

    for (i in 0..9) {
        val taskId = i + 1 // Task identifier for logging
        executorService.execute { // Task to run in the background
            Log.d(
                "TAG",
                "Task " + taskId + " is running in: " + Thread.currentThread().name
            )

            // Simulate a time-consuming task
            try {
                Thread.sleep(1000) // Sleep for 1 second
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            Log.d(
                "TAG",
                "Task " + taskId + " completed in: " + Thread.currentThread().name
            )
        }
    }
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

    //Zip
    val list1 = listOf(1, 2, 3, 4)
    val list2 = listOf("a", "b", "c", "d")
    val zip = list1.zip(list2)
    println(zip)

    //UnZip
    val unZip = zip.unzip();
    println(unZip)

    //reduceIndexed
    val reduceIndexed = list1.reduceIndexed { i, a, v ->
        if (i == 2) {
            a
        } else {
            a + v
        }

    }
    println(reduceIndexed)

    //foldIndexed
    val foldIndexed = list1.foldIndexed(5) { i, a, v ->
        if (i == 2) {
            a
        } else {
            a + v
        }

    }

    //println(foldIndexed)
    val names = listOf("Alice", "Arun", "Aahaa", "Bob", "Brenda", "Clara", "Carl")
    val groupedCounts = names.groupBy { it.length }
    println(groupedCounts)

}

