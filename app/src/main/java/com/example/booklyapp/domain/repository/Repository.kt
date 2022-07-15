package com.example.booklyapp.domain.repository

import com.example.booklyapp.domain.models.BestSellers
import com.example.booklyapp.domain.models.CarouselSellers
import com.example.booklyapp.domain.models.SimilarBooks

interface Repository {

    suspend fun bestSellersBooks(): List<BestSellers>

    suspend fun carouselSellersBooks(): List<CarouselSellers>

    suspend fun similarBooks(): List<SimilarBooks>

}