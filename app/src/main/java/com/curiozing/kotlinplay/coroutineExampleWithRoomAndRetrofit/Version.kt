package com.curiozing.kotlinplay.coroutineExampleWithRoomAndRetrofit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity("androidVersion")
data class Version(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo("name")
    var name: String,

    @ColumnInfo("version")
    var version: String,
)