package com.example.deliveryprojecttest.domain.usecase

import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.domain.repository.BasketService

class DeleteBasketUseCase(private val basketService: BasketService) {

    fun execute(dishes: Dishes){
        basketService.deleteOfBasket(dishes = dishes)
    }

}