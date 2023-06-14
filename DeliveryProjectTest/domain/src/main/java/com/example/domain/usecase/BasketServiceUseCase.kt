package com.example.domain.usecase

import com.example.data.service.BasketObserver
import com.example.domain.model.Dishes
import com.example.domain.repository.BasketService

class BasketServiceUseCase(private val basketService: BasketService) {

    fun add(dishes: Dishes){
        basketService.addToBasket(dishes = dishes)
    }

    fun delete(dishes: Dishes){
        basketService.deleteOfBasket(dishes = dishes)
    }

}