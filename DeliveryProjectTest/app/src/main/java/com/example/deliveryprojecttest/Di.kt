package com.example.deliveryprojecttest

import com.example.data.api.Api
import com.example.domain.repository.Repository
import com.example.data.repository.RepositoryImpl
import com.example.data.service.BasketServiceImpl
import com.example.domain.repository.BasketService
import com.example.domain.usecase.BasketServiceUseCase
import com.example.domain.usecase.GetCategoriesUseCase
import com.example.domain.usecase.GetDishesUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Di {

    val getCategoriesUseCase by lazy {
        GetCategoriesUseCase(repository = repository)
    }

    val getDishesUseCase by lazy {
        GetDishesUseCase(repository = repository)
    }

    val basketServiceUseCase by lazy {
        BasketServiceUseCase(basketService = basketService)
    }


    private val basketService: BasketService by lazy {
        BasketServiceImpl()
    }

    private val repository: Repository by lazy {
        RepositoryImpl(api = api)
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
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private val api: Api by lazy {
        retrofit.create(Api::class.java)
    }
}

/**
 * KOIN
 *
 *
 */