package com.example.deliveryprojecttest.domain.usecase

import com.example.deliveryprojecttest.domain.model.ResponseCategories
import com.example.deliveryprojecttest.domain.repository.Repository

class GetCategoriesUseCase(private val repository: Repository) {

    suspend fun execute(): ResponseCategories{
        return repository.getCategory()
    }

}