package com.example.data.repository

import com.example.domain.model.ResponseCategories
import com.example.domain.model.ResponseDishes
import com.example.domain.repository.Repository

class RepositoryImpl(private val api: com.example.data.api.Api) :
    Repository {

    override suspend fun getCategory(): ResponseCategories {
        return api.getCategory()
    }

    override suspend fun getDishes(): ResponseDishes {
        return api.getDishes()
    }

}