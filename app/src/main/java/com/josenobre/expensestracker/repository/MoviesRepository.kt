package com.josenobre.expensestracker.repository

import androidx.lifecycle.LiveData
import com.josenobre.expensestracker.network.api.ApiService
import com.josenobre.expensestracker.network.api.adapter.AppExecutors
import com.josenobre.expensestracker.network.api.adapter.NetworkBoundResource
import com.josenobre.expensestracker.network.api.adapter.Resource
import com.josenobre.expensestracker.network.api.responses.MovieResponse
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val apiService: ApiService, private val appExecutors: AppExecutors) {

    fun retrievePopularMovies(): LiveData<Resource<MovieResponse>> {
        return object : NetworkBoundResource<MovieResponse>(appExecutors) {
            override fun createCall() = apiService.getPopularMovies()
        }.asLiveData()
    }
}