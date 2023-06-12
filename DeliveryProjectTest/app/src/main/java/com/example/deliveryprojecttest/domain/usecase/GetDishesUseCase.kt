package com.example.deliveryprojecttest.domain.usecase

import com.example.deliveryprojecttest.domain.model.ResponseDishes
import com.example.deliveryprojecttest.domain.repository.Repository

class GetDishesUseCase(private val repository: Repository) {

    suspend fun execute(): ResponseDishes{
        return repository.getDishes()
    }

}