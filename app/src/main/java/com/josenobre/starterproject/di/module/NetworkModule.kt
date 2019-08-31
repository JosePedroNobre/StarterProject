package com.josenobre.starterproject.di.module

import androidx.annotation.NonNull
import com.josenobre.starterproject.BuildConfig
import com.josenobre.starterproject.network.api.AuthInterceptor
import com.josenobre.starterproject.network.api.ApiService
import com.josenobre.starterproject.network.api.adapter.LiveDataCallAdapterFactory
import com.josenobre.starterproject.utils.AppConstants.CONNECT_TIMEOUT
import com.josenobre.starterproject.utils.AppConstants.READ_TIMEOUT
import com.josenobre.starterproject.utils.AppConstants.WRITE_TIMEOUT
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private val TAG = com.josenobre.starterproject.di.module.NetworkModule::class.java.simpleName
    }

    @Singleton
    @Provides
    fun providesLiveDataCallAdapterFactory() =
        com.josenobre.starterproject.network.api.adapter.LiveDataCallAdapterFactory()

    @Provides
    @Singleton
    internal fun provideOkHttpInterceptors(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
    }

    @Provides
    @Singleton
    internal fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(com.josenobre.starterproject.network.api.AuthInterceptor())
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofitClient(@NonNull okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()) // Serialize Objects
            .addCallAdapterFactory(com.josenobre.starterproject.network.api.adapter.LiveDataCallAdapterFactory())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // Set call to return {@link Observable}
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): com.josenobre.starterproject.network.api.ApiService = retrofit.create(
        com.josenobre.starterproject.network.api.ApiService::class.java)
}