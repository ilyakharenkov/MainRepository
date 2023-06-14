package com.example.domain.usecase

import com.example.domain.model.ResponseDishes
import com.example.domain.repository.Repository

class GetDishesUseCase(private val repository: Repository) {

    suspend fun execute(): ResponseDishes {
        return repository.getDishes()
    }

}