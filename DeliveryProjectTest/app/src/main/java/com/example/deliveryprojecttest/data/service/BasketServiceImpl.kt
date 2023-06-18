package com.example.deliveryprojecttest.data.service

import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.domain.repository.BasketService


/**
 * You can use ROOM data base
 */
class BasketServiceImpl : BasketService {

    private val observable = mutableSetOf<(list: List<Dishes>)->Unit>()

    private var list: MutableList<Dishes> = mutableListOf()

    private var checkCount: Int = 1

    override fun addToBasket(dishes: Dishes) {
        val di = list.firstOrNull {
            it.id == dishes.id
        }
        if(di == dishes) {
            checkCount++
            update()
        } else {
            list = ArrayList(list)
            list.add(dishes)
            update()
        }
    }

    override fun deleteOfBasket(dishes: Dishes){
        val id = list.indexOfFirst { it.id == dishes.id }
        list = ArrayList(list)
        list.removeAt(id)
        update()
    }

    override fun addListener(listObserver: (list: List<Dishes>) -> Unit) {
        observable.add(listObserver)
        update()
    }

    override fun removeListener(listObserver: (list: List<Dishes>) -> Unit) {
        observable.remove(listObserver)
    }

    private fun update(){
        observable.forEach { it(list) }
    }


}