package com.example.booklyapp.domain.models

import com.google.gson.annotations.SerializedName

data class SimilarBooks(
    @SerializedName("image")
    val image: String
)