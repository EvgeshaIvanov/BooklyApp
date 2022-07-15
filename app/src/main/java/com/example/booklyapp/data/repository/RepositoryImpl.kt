package com.example.booklyapp.data.repository

import com.example.booklyapp.data.network.RetrofitInstance
import com.example.booklyapp.domain.models.BestSellers
import com.example.booklyapp.domain.models.CarouselSellers
import com.example.booklyapp.domain.models.SimilarBooks
import com.example.booklyapp.domain.repository.Repository

class RepositoryImpl : Repository {

    override suspend fun bestSellersBooks(): List<BestSellers> {
        val response = RetrofitInstance.apiHelper.getBestSellers()
        if (response.failed) {
            return emptyList()
        }
        if (!response.isSuccessful) {
            return emptyList()
        }
        return response.body.map { it.mapper() }
    }

    override suspend fun carouselSellersBooks(): List<CarouselSellers> {
        val response = RetrofitInstance.apiHelper.getCarouselSellers()
        if (response.failed) {
            return emptyList()
        }
        if (!response.isSuccessful) {
            return emptyList()
        }
        return response.body.map { it.mapper() }
    }

    override suspend fun similarBooks(): List<SimilarBooks> {
        val response = RetrofitInstance.apiHelper.getSimilarBooks()
        if (response.failed) {
            return emptyList()
        }
        if (!response.isSuccessful) {
            return emptyList()
        }
        return response.body.map { it.mapper() }
    }
}