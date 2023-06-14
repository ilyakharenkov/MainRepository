package com.example.deliveryprojecttest.domain.repository

import com.example.deliveryprojecttest.data.service.BasketObserver
import com.example.deliveryprojecttest.domain.model.Dishes

interface BasketService {

    fun addToBasket(dishes: Dishes)

    fun deleteOfBasket(dishes: Dishes)

}