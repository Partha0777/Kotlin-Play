package com.curiozing.kotlinplay

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit.AppDatabase

class MyApplication : Application() {

    private lateinit var db: AppDatabase

    init {
        instance = this
    }

    companion object {
        private var instance: MyApplication? = null
        fun getContext(): Context? {
            return instance?.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this.applicationContext,
            AppDatabase::class.java,
            "androidVersionDB"
        ).build()
    }

    fun getAppDatabase(): AppDatabase {
        return db
    }
}