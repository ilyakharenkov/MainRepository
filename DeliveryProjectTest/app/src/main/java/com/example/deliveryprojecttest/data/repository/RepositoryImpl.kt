package com.example.deliveryprojecttest.data.repository

import com.example.deliveryprojecttest.data.api.Api
import com.example.deliveryprojecttest.data.repository.model.ResponseCategories

class RepositoryImpl(private val api: Api) : Repository {

    override suspend fun getCategory(): ResponseCategories {
        return api.getCategory()
    }

}