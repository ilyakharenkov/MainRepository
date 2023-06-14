package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.deliveryprojecttest.Di
import com.example.data.service.BasketObserver
import com.example.domain.model.Dishes
import com.example.domain.usecase.BasketServiceUseCase

class BasketViewModel(
    private val basketServiceUseCase: com.example.domain.usecase.BasketServiceUseCase
) : ViewModel() {

    private val _listBasket = MutableLiveData<List<com.example.domain.model.Dishes>>()
    val listBasket: LiveData<List<com.example.domain.model.Dishes>> = _listBasket


}