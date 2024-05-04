package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface VersionDAO {

    @Insert
    fun insertVersion(version: Version)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllVersion(versions: List<Version>)

    @Query("SELECT * FROM androidVersion")
    suspend fun getVersions(): List<Version>



}