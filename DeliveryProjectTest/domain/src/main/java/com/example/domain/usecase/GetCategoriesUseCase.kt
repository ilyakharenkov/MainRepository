package com.example.domain.usecase

import com.example.domain.model.ResponseCategories
import com.example.domain.repository.Repository

class GetCategoriesUseCase(private val repository: Repository) {

    suspend fun execute(): ResponseCategories {
        return repository.getCategory()
    }

}