package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.domain.usecase.BasketServiceUseCase
import kotlinx.coroutines.launch

class BasketViewModel(
    private val basketServiceUseCase: BasketServiceUseCase
) : ViewModel() {

    private val _listBasket = MutableLiveData<List<Dishes>>()
    val listBasket: LiveData<List<Dishes>> = _listBasket

    init {
        currentListener()
    }

    private fun currentListener() {
        viewModelScope.launch {
            basketServiceUseCase.listenerCurrentList().collect {
                _listBasket.value = it
            }
        }
    }

    fun addDishes(dishes: Dishes) {
        basketServiceUseCase.add(dishes = dishes)
    }

    fun deleteDishes(dishes: Dishes) {
        basketServiceUseCase.delete(dishes = dishes)
    }

}