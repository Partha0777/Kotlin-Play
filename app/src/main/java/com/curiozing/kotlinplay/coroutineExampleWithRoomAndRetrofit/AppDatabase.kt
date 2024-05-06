package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Version::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun versionDAO(): VersionDAO
}