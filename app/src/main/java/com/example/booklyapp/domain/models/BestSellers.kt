package com.example.booklyapp.domain.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class BestSellers(
    @SerializedName("title")
    val title: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("image")
    val image: String,
    @SerializedName("rate")
    val rate: RateModel
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readString()!!,
        parcel.readParcelable<RateModel>(RateModel::class.java.classLoader)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(author)
        parcel.writeDouble(price)
        parcel.writeString(image)
        parcel.writeParcelable(rate, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BestSellers> {
        override fun createFromParcel(parcel: Parcel): BestSellers {
            return BestSellers(parcel)
        }

        override fun newArray(size: Int): Array<BestSellers?> {
            return arrayOfNulls(size)
        }
    }

}
