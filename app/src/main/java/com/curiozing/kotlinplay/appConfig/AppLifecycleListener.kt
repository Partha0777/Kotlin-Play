package com.curiozing.kotlinplay.appConfig

import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

class AppLifecycleListener : DefaultLifecycleObserver{
    override fun onStart(owner: LifecycleOwner) {
        Log.d("AppLifecycle", "App in foreground")
    }

    override fun onStop(owner: LifecycleOwner) {
        Log.d("AppLifecycle", "App in background")
    }
}