package com.example.booklyapp.domain.usecase

import com.example.booklyapp.domain.repository.Repository

class BestSellersUseCase(private val repository: Repository) {

    suspend fun execute() = repository.bestSellersBooks()

}