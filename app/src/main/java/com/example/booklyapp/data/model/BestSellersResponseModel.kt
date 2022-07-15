package com.example.booklyapp.data.model

import com.example.booklyapp.domain.models.BestSellers
import com.example.booklyapp.domain.models.RateModel
import com.google.gson.annotations.SerializedName

data class BestSellersResponseModel(
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
) {
    fun mapper(): BestSellers {
        return BestSellers(this.title, this.author, this.price, this.image, this.rate)
    }
}
