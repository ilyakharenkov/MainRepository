package com.example.deliveryprojecttest.data.service

import com.example.deliveryprojecttest.domain.model.Dishes

class BasketService() {

    var list: MutableList<Dishes> = mutableListOf()

    private val observer = mutableListOf<(dishes: List<Dishes>) -> Unit>()

    fun generateList(){

    }

    fun addToBasket(dishes: Dishes) {
        list = ArrayList(list)
        list.add(dishes)
        update()
    }

    fun deleteFromBasket(dishes: Dishes){
        list
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