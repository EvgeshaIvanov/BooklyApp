package com.example.booklyapp.data.network

import com.example.booklyapp.data.model.BestSellersResponseModel
import com.example.booklyapp.data.model.CarouselResponseModel
import com.example.booklyapp.data.model.SimilarBooksResponseModel
import com.example.booklyapp.utils.Constants.BEST_URL
import com.example.booklyapp.utils.Constants.CAROUSEL_URL
import com.example.booklyapp.utils.Constants.SIMILAR_URL
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(CAROUSEL_URL)
    suspend fun carouselSellers(): Response<List<CarouselResponseModel>>

    @GET(BEST_URL)
    suspend fun bestSellers(): Response<List<BestSellersResponseModel>>

    @GET(SIMILAR_URL)
    suspend fun similarBooks(): Response<List<SimilarBooksResponseModel>>

}