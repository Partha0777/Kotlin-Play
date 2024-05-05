package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface VersionDAO {

    @Insert
    suspend fun insertVersion(version: Version)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllVersion(versions: List<Version>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateAllVersions(versions: List<Version>)

    @Query("SELECT * FROM androidVersion")
    suspend fun getVersions(): List<Version>



}