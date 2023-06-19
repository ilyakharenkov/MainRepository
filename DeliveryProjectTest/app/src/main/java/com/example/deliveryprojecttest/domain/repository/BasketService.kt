package com.example.deliveryprojecttest.domain.repository

import com.example.deliveryprojecttest.domain.model.Dishes
import kotlinx.coroutines.flow.Flow

interface BasketService {

    fun addToBasket(dishes: Dishes)

    fun deleteOfBasket(dishes: Dishes)

    fun checkCount(): Int

    fun listenerCurrentList(): Flow<List<Dishes>>

}