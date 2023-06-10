package com.example.deliveryprojecttest.data

import com.example.deliveryprojecttest.data.api.Api
import com.example.deliveryprojecttest.data.repository.Repository
import com.example.deliveryprojecttest.data.repository.RepositoryImpl
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Di {

    val repository: Repository by lazy {
        RepositoryImpl(api = api)
    }

    private val gson by lazy {
        GsonBuilder()
            .create()
    }
    private val okHttpClient: OkHttpClient by lazy {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    private val api: Api by lazy {
        retrofit.create(Api::class.java)
    }
}