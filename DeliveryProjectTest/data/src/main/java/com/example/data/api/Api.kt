package com.example.data.api


import com.example.domain.model.ResponseCategories
import com.example.domain.model.ResponseDishes
import retrofit2.http.GET


interface Api {

    @GET("v3/058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getCategory(): ResponseCategories

    @GET("v3/aba7ecaa-0a70-453b-b62d-0e326c859b3b")
    suspend fun getDishes(): ResponseDishes

}