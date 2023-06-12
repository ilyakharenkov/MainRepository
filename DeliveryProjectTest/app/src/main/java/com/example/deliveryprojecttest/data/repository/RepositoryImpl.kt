package com.example.deliveryprojecttest.data.repository

import com.example.deliveryprojecttest.data.api.Api
import com.example.deliveryprojecttest.domain.model.ResponseCategories
import com.example.deliveryprojecttest.domain.model.ResponseDishes
import com.example.deliveryprojecttest.domain.repository.Repository

class RepositoryImpl(private val api: Api) : Repository {

    override suspend fun getCategory(): ResponseCategories {
        return api.getCategory()
    }

    override suspend fun getDishes(): ResponseDishes {
        return api.getDishes()
    }

}