package com.curiozing.kotlinplay.parcelableAndSerializable

import android.os.Parcel
import android.os.Parcelable

data class DataParcelable(var data: String?, var data2:Int):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(data)
        parcel.writeInt(data2)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataParcelable> {
        override fun createFromParcel(parcel: Parcel): DataParcelable {
            return DataParcelable(parcel)
        }

        override fun newArray(size: Int): Array<DataParcelable?> {
            return arrayOfNulls(size)
        }
    }
}