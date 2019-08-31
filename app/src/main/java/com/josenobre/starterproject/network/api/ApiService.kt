package com.josenobre.starterproject.network.api

import androidx.lifecycle.LiveData
import com.josenobre.starterproject.network.api.responses.MovieResponse
import com.josenobre.starterproject.network.model.ApiResponse
import retrofit2.http.GET

interface ApiService {

    @GET("discover/movie?sort_by=popularity.desc")
    fun getPopularMovies(): LiveData<com.josenobre.starterproject.network.model.ApiResponse<com.josenobre.starterproject.network.api.responses.MovieResponse>>
}