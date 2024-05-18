package com.curiozing.kotlinplay.kotlinVsJava.coroutine

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoroutineExample {
    fun startCoroutine(){
        CoroutineScope(Dispatchers.Main).launch {  }
    }
}