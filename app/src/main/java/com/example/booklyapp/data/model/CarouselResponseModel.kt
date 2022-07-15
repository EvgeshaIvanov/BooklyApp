package com.example.booklyapp.data.model

import com.example.booklyapp.domain.models.CarouselSellers
import com.google.gson.annotations.SerializedName

data class CarouselResponseModel(
    @SerializedName("image")
    val image: String
) {
    fun mapper() = CarouselSellers(this.image)
}
