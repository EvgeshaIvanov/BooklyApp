package com.example.booklyapp.data.network

import com.example.booklyapp.data.model.BestSellersResponseModel
import com.example.booklyapp.data.model.CarouselResponseModel
import com.example.booklyapp.data.model.SimilarBooksResponseModel
import com.example.booklyapp.utils.BaseDataSource
import com.example.booklyapp.utils.Result

class ApiHelper(private val apiService: ApiService) : BaseDataSource() {

    suspend fun getCarouselSellers(): Result<List<CarouselResponseModel>> {
        return apiCall { apiService.carouselSellers() }
    }

    suspend fun getBestSellers(): Result<List<BestSellersResponseModel>> {
        return apiCall { apiService.bestSellers() }
    }

    suspend fun getSimilarBooks(): Result<List<SimilarBooksResponseModel>> {
        return apiCall { apiService.similarBooks() }
    }
}