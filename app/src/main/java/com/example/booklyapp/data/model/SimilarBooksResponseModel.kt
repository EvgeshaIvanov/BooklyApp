package com.example.booklyapp.data.model

import com.example.booklyapp.domain.models.SimilarBooks
import com.google.gson.annotations.SerializedName

data class SimilarBooksResponseModel(
    @SerializedName("image")
    val image: String
) {
    fun mapper(): SimilarBooks {
        return SimilarBooks(this.image)
    }
}
