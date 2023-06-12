package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.domain.usecase.GetDishesUseCase
import kotlinx.coroutines.launch

class CategoryViewModel(private val getDishesUseCase: GetDishesUseCase) : ViewModel() {

    private val _listDishes = MutableLiveData<List<Dishes>>()
    val listDishes: LiveData<List<Dishes>> = _listDishes

    private val _listTags = MutableLiveData<List<String>>()
    val listTags: LiveData<List<String>> = _listTags

    init {
        initListDishes()
    }

    private fun initListDishes() {
        viewModelScope.launch {
            _listDishes.value = getDishesUseCase.execute().dishes
            getDishesUseCase.execute().dishes.map {
                _listTags.value = it.tegs
            }
        }
    }


}