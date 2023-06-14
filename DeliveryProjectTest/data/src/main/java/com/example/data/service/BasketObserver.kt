package com.example.data.service

import com.example.domain.model.Dishes

interface BasketObserver {

    fun observe(list: List<Dishes>)

}