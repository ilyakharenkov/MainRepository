package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliveryprojecttest.Di
import com.example.deliveryprojecttest.data.service.BasketObserver
import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.domain.usecase.BasketServiceUseCase

class BasketViewModel(
    private val basketServiceUseCase: BasketServiceUseCase
) : ViewModel() {

    private val _listBasket = MutableLiveData<List<Dishes>>()
    val listBasket: LiveData<List<Dishes>> = _listBasket


}