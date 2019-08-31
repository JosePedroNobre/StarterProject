package com.josenobre.starterproject.network.model

import retrofit2.Response

@Suppress("unused")
open class ApiResponse<T> {

    companion object {
        fun <T> create(url: String, throwable: Throwable): com.josenobre.starterproject.network.model.ApiErrorResponse<T> {
            return com.josenobre.starterproject.network.model.ApiErrorResponse(
                url,
                520,
                throwable.message ?: "Something went wrong"
            )
        }

        fun <T> create(url: String, response: Response<T>): com.josenobre.starterproject.network.model.ApiResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                com.josenobre.starterproject.network.model.ApiSuccessResponse(url, body)
            } else {
                val code = response.code()
                val message = response.errorBody()?.string()
                val errorMessage = if (message.isNullOrEmpty()) {
                    response.message()
                } else {
                    message
                }
                com.josenobre.starterproject.network.model.ApiErrorResponse(
                    url,
                    code,
                    errorMessage ?: "Something went wrong"
                )
            }
        }
    }
}

data class ApiSuccessResponse<T>(val url: String, val body: T?) : com.josenobre.starterproject.network.model.ApiResponse<T>()

data class ApiErrorResponse<T>(val url: String, val errorCode: Int, val errorMessage: String) : com.josenobre.starterproject.network.model.ApiResponse<T>()
