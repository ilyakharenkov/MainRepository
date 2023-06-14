package com.example.deliveryprojecttest

import com.example.deliveryprojecttest.data.api.Api
import com.example.deliveryprojecttest.domain.repository.Repository
import com.example.deliveryprojecttest.data.repository.RepositoryImpl
import com.example.deliveryprojecttest.data.service.BasketServiceImpl
import com.example.deliveryprojecttest.domain.repository.BasketService
import com.example.deliveryprojecttest.domain.usecase.AddBasketServiceUseCase
import com.example.deliveryprojecttest.domain.usecase.DeleteBasketUseCase
import com.example.deliveryprojecttest.domain.usecase.GetCategoriesUseCase
import com.example.deliveryprojecttest.domain.usecase.GetDishesUseCase
import com.google.gson.GsonBuilder
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

    val addBasketServiceUseCase by lazy {
        AddBasketServiceUseCase(basketService = basketService)
    }

    val deleteBasketServiceUseCase by lazy {
        DeleteBasketUseCase(basketService = basketService)
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