package com.example.deliveryprojecttest.data.repository

import com.example.deliveryprojecttest.data.api.Api
import com.example.deliveryprojecttest.domain.model.ResponseCategories
import com.example.deliveryprojecttest.domain.model.ResponseDishes
import com.example.deliveryprojecttest.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryImpl(private val api: Api) : Repository {

    override suspend fun getCategory(): ResponseCategories = withContext(Dispatchers.IO){
        return@withContext api.getCategory()
    }

    override suspend fun getDishes(): ResponseDishes = withContext(Dispatchers.IO){
        return@withContext api.getDishes()
    }

}