package com.example.deliveryprojecttest.domain.repository

import com.example.deliveryprojecttest.domain.model.Dishes

interface BasketService {

    fun addToBasket(dishes: Dishes)

    fun deleteOfBasket(dishes: Dishes)

    fun checkCount(): Int

    fun addListener(listObserver: (list: List<Dishes>) -> Unit)

    fun removeListener(listObserver: (list: List<Dishes>) -> Unit)

}