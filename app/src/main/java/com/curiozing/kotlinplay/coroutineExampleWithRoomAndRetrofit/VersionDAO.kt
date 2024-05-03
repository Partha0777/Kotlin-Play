package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import androidx.room.Insert
import androidx.room.Query

interface VersionDAO {

    @Insert
    fun insertVersion(version: Version)

    @Query("SELECT * FROM androidVersion")
    fun getVersions(): List<Version>
}