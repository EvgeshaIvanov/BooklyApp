package com.example.booklyapp.domain.usecase

import com.example.booklyapp.domain.models.SimilarBooks
import com.example.booklyapp.domain.repository.Repository

class SimilarBooksUseCase(private val repository: Repository) {

    suspend fun execute(): List<SimilarBooks> {
        return repository.similarBooks()
    }

}