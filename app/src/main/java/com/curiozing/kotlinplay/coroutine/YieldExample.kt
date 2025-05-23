package com.curiozing.kotlinplay.coroutine;

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield

suspend fun downloadFile(url: String, delay: Long): String {
    println("Downloading $url...")
    delay(delay)
    return "Downloaded $url"
}

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun main() {
    val singleThreadedDispatcher = Dispatchers.Default.limitedParallelism(1)

    val data = flow{
        repeat(5){
            emit(it)
        }
    }

    data.catch {

        }
        .onCompletion {

        }
        .onEach {
            println("On Complete - $it")
        }
        .collect()



    //Added Coroutine example
    // GlobalScope.launch(context = Dispatchers.IO + SupervisorJob() + CoroutineName("") + CoroutineExceptionHandler(handler = {e,r ->})) {  }

    withContext(singleThreadedDispatcher) {
        launch {
            repeat(5) {
                updateProgressBar(it, "A")
                yield()
            }
        }

        launch {
            repeat(5) {
                updateProgressBar(it, "B")
                yield()
            }
        }
    }
}

fun updateProgressBar(value: Int, marker: String) {
    print(marker)
}


/*fun main(): Unit = runBlocking {

        launch {
                for (i in 1..5) {
                        println("Computation $i in Coroutine 1")
                }
        }

        launch {
                for (i in 1..5) {
                        println("Task $i in Coroutine 2")
                }
        }

}*/

