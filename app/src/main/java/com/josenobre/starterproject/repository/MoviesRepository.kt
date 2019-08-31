package com.josenobre.starterproject.repository

import androidx.lifecycle.LiveData
import com.josenobre.starterproject.network.api.ApiService
import com.josenobre.starterproject.network.api.adapter.AppExecutors
import com.josenobre.starterproject.network.api.adapter.NetworkBoundResource
import com.josenobre.starterproject.network.api.adapter.Resource
import com.josenobre.starterproject.network.api.responses.MovieResponse
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val apiService: com.josenobre.starterproject.network.api.ApiService, private val appExecutors: com.josenobre.starterproject.network.api.adapter.AppExecutors) {

    fun retrievePopularMovies(): LiveData<com.josenobre.starterproject.network.api.adapter.Resource<com.josenobre.starterproject.network.api.responses.MovieResponse>> {
        return object : com.josenobre.starterproject.network.api.adapter.NetworkBoundResource<com.josenobre.starterproject.network.api.responses.MovieResponse>(appExecutors) {
            override fun createCall() = apiService.getPopularMovies()
        }.asLiveData()
    }
}