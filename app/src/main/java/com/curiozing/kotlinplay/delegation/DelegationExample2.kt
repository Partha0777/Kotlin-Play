package com.curiozing.kotlinplay.delegation

class DelegationExample2 : Analytics by ImplAnalytics(), Logs by ImplLogs() {

    fun onCreate() {
        recordAnalytics("OnStart")

        logData("Error occurred!")
    }
}

interface Analytics {

    fun recordAnalytics(data: String)
}


interface Logs {

    fun logData(data: String)
}


open class ImplAnalytics : Analytics {
    override fun recordAnalytics(data: String) {
    }

}

class ImplLogs : Logs {
    override fun logData(data: String) {
    }
}