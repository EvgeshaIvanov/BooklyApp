package com.example.booklyapp.domain.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class RateModel(
    @SerializedName("score")
    val score: Double,
    @SerializedName("amount")
    val amount: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(score)
        parcel.writeInt(amount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RateModel> {
        override fun createFromParcel(parcel: Parcel): RateModel {
            return RateModel(parcel)
        }

        override fun newArray(size: Int): Array<RateModel?> {
            return arrayOfNulls(size)
        }
    }

}
