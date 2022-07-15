package com.example.booklyapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booklyapp.data.repository.RepositoryImpl
import com.example.booklyapp.domain.models.BestSellers
import com.example.booklyapp.domain.models.CarouselSellers
import com.example.booklyapp.domain.models.SimilarBooks
import com.example.booklyapp.domain.usecase.BestSellersUseCase
import com.example.booklyapp.domain.usecase.CarouselBooksUseCase
import com.example.booklyapp.domain.usecase.SimilarBooksUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repositoryImpl = RepositoryImpl()

    private val bestSellersUseCase = BestSellersUseCase(repositoryImpl)

    private val carouselBooksUseCase = CarouselBooksUseCase(repositoryImpl)

    private val similarBooksUseCase = SimilarBooksUseCase(repositoryImpl)

    val bestSellersLiveData = MutableLiveData<List<BestSellers>>()

    val carouselSellersLiveData = MutableLiveData<List<CarouselSellers>>()

    val similarBooksLiveData = MutableLiveData<List<SimilarBooks>>()

    init {

        bestSellersBooks()

        carouselSellersBooks()
    }

    private fun bestSellersBooks() {
        viewModelScope.launch {
            val list = bestSellersUseCase.execute()
            bestSellersLiveData.postValue(list)
        }
    }

    private fun carouselSellersBooks() {
        viewModelScope.launch {
            val list = carouselBooksUseCase.execute()
            carouselSellersLiveData.postValue(list)
        }
    }

    fun similarBooks() {
        viewModelScope.launch {
            val list = similarBooksUseCase.execute()
            similarBooksLiveData.postValue(list)
        }
    }

}