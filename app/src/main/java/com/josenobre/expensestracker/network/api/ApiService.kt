package com.josenobre.expensestracker.network.api

import androidx.lifecycle.LiveData
import com.josenobre.expensestracker.network.api.responses.MovieResponse
import com.josenobre.expensestracker.network.model.ApiResponse
import retrofit2.http.GET

interface ApiService {

    @GET("discover/movie?sort_by=popularity.desc")
    fun getPopularMovies(): LiveData<ApiResponse<MovieResponse>>
}