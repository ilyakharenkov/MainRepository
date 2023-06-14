package com.example.domain.repository

import com.example.data.service.BasketObserver
import com.example.domain.model.Dishes

interface BasketService {

    fun addToBasket(dishes: Dishes)

    fun deleteOfBasket(dishes: Dishes)

}