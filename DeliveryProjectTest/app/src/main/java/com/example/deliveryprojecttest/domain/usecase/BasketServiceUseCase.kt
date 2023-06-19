package com.example.deliveryprojecttest.domain.usecase

import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.domain.repository.BasketService
import kotlinx.coroutines.flow.Flow

class BasketServiceUseCase(private val basketService: BasketService) {

    fun add(dishes: Dishes){
        basketService.addToBasket(dishes = dishes)
    }

    fun delete(dishes: Dishes){
        basketService.deleteOfBasket(dishes = dishes)
    }

    fun checkCount(): Int {
        return basketService.checkCount()
    }

    fun listenerCurrentList(): Flow<List<Dishes>> {
        return basketService.listenerCurrentList()
    }

}