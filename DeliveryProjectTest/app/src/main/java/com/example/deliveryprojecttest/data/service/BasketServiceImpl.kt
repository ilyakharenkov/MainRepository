package com.example.deliveryprojecttest.data.service

import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.domain.repository.BasketService
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.callbackFlow
import java.nio.Buffer


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
            checkCount()
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

    override fun checkCount(): Int {
        var count = checkCount
        count++
        checkCount = count
        return checkCount
    }

    override fun listenerCurrentList(): Flow<List<Dishes>> {
        return callbackFlow {
            val listeners: (list: List<Dishes>) -> Unit = {
                trySend(it)
            }
            observable.add(listeners)
            update()
            awaitClose {
                observable.remove(listeners)
            }
        }
    }

    private fun update(){
        observable.forEach { it(list) }
    }


}