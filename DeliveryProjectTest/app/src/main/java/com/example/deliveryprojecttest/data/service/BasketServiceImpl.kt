package com.example.deliveryprojecttest.data.service

import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.domain.repository.BasketService

class BasketServiceImpl : BasketService  {

    var list: MutableList<Dishes> = mutableListOf()

    private val observer = mutableListOf<(dishes: List<Dishes>) -> Unit>()

    override fun addToBasket(dishes: Dishes) {
        list = ArrayList(list)
        list.add(dishes)
        update()
    }

    override fun deleteOfBasket(dishes: Dishes){
        val id = list.indexOfFirst { it.id == dishes.id }
        list.removeAt(id)
        update()
    }

    fun addListener(listener: (dishes: List<Dishes>) -> Unit){
        observer.add(listener)
        update()
    }

    fun removeListener(listener: (dishes: List<Dishes>) -> Unit){
        observer.remove(listener)
    }

    private fun update(){
        observer.forEach { it.invoke(list) }
    }

}