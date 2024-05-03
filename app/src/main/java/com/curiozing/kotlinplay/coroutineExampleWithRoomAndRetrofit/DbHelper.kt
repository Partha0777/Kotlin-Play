package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import android.annotation.SuppressLint
import androidx.room.Room
import androidx.room.RoomDatabase
import com.curiozing.kotlinplay.MyApplication

object DbHelper {

    var db = MyApplication.getContext()
        ?.let { Room.databaseBuilder(it,AppDatabase::class.java,"androidVersionDB") }
}