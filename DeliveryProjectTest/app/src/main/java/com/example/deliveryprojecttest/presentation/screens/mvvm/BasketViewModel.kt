package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.domain.usecase.BasketServiceUseCase

class BasketViewModel(
    private val basketServiceUseCase: BasketServiceUseCase
) : ViewModel() {

    private val _listBasket = MutableLiveData<List<Dishes>>()
    val listBasket: LiveData<List<Dishes>> = _listBasket

    private val _countDishes = MutableLiveData<Int>()
    val countDishes: LiveData<Int> = _countDishes

    private val listener: (List<Dishes>) -> Unit = {
        _listBasket.value = it
    }

    init {
        basketServiceUseCase.addListener(listObserver = listener)
        countDishes()
    }

    override fun onCleared() {
        super.onCleared()
        basketServiceUseCase.removeListener(listObserver = listener)
    }

    fun addDishes(dishes: Dishes){
        basketServiceUseCase.add(dishes = dishes)
    }

    fun deleteDishes(dishes: Dishes){
        basketServiceUseCase.delete(dishes = dishes)
    }

    private fun countDishes(){
        _countDishes.value = basketServiceUseCase.checkCount()
    }



}