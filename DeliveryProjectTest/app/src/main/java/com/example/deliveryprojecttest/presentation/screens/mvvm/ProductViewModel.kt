package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Dishes
import com.example.domain.usecase.BasketServiceUseCase
import com.example.domain.usecase.GetDishesUseCase
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ProductViewModel(
    private val basketServiceUseCase: com.example.domain.usecase.BasketServiceUseCase,
    private val getDishesUseCase: com.example.domain.usecase.GetDishesUseCase
) : ViewModel() {

    private val _dishes = MutableLiveData<com.example.domain.model.Dishes>()
    val dishes: LiveData<com.example.domain.model.Dishes> = _dishes

    fun getById(id: Int){
        viewModelScope.launch {
            val result = getDishesUseCase.execute().dishes.firstOrNull {
                it.id == id
            } ?: throw IllegalArgumentException()
            _dishes.value = result
        }
    }

    fun addDishesInBasket(){
        _dishes.value?.let { basketServiceUseCase.add(dishes = it) }
    }

}
