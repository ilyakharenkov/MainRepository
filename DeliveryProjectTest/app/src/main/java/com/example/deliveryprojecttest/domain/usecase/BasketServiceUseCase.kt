package com.example.deliveryprojecttest.domain.usecase

import com.example.deliveryprojecttest.data.service.BasketObserver
import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.domain.repository.BasketService

class BasketServiceUseCase(private val basketService: BasketService) {

    fun add(dishes: Dishes){
        basketService.addToBasket(dishes = dishes)
    }

    fun delete(dishes: Dishes){
        basketService.deleteOfBasket(dishes = dishes)
    }

}