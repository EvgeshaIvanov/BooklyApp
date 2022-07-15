package com.example.booklyapp.utils

import retrofit2.Response

abstract class BaseDataSource {

    protected suspend fun <T> apiCall(apiCall: suspend () -> Response<T>): Result<T> {
        return try {
            Result.success(apiCall.invoke())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}