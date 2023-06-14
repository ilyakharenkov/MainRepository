package com.example.deliveryprojecttest.data.service

import com.example.deliveryprojecttest.domain.model.Dishes

interface BasketObserver {

    fun observe(list: List<Dishes>)

}