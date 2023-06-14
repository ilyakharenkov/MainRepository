package com.example.data.service

import com.example.domain.model.Dishes
import com.example.domain.repository.BasketService

class BasketServiceImpl : BasketService {

    private val listObserver = mutableSetOf<BasketObserver>()

    private var list: MutableList<Dishes> = mutableListOf()

    override fun addToBasket(dishes: Dishes) {
        list = ArrayList(list)
        list.add(dishes)
    }

    override fun deleteOfBasket(dishes: Dishes){
        val id = list.indexOfFirst { it.id == dishes.id }
        list.removeAt(id)
    }



}