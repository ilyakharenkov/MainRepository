package com.example.deliveryprojecttest.data.api

import com.example.deliveryprojecttest.data.repository.model.ResponseCategories
import retrofit2.http.GET

interface Api {

    @GET("v3/058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getCategory(): ResponseCategories

}