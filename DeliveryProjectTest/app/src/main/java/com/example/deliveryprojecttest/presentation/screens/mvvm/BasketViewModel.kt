package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryprojecttest.Di
import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.domain.model.ResponseCategories
import com.example.deliveryprojecttest.domain.usecase.GetCategoriesUseCase
import kotlinx.coroutines.launch

class BasketViewModel() : ViewModel() {

    private val _listBasket = MutableLiveData<List<Dishes>>()
    val listBasket: LiveData<List<Dishes>> = _listBasket

    init {

    }

    fun addItemBasket(){

    }


}