package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.domain.usecase.AddBasketServiceUseCase
import com.example.deliveryprojecttest.domain.usecase.GetDishesUseCase
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class ProductViewModel(
    private val addBasketServiceUseCase: AddBasketServiceUseCase,
    private val getDishesUseCase: GetDishesUseCase
) : ViewModel() {

    private val _dishes = MutableLiveData<Dishes>()
    val dishes: LiveData<Dishes> = _dishes

    fun getById(id: Int){
        viewModelScope.launch {
            val result = getDishesUseCase.execute().dishes.firstOrNull {
                it.id == id
            } ?: throw IllegalArgumentException()
            _dishes.value = result
        }
    }

    fun addDishesInBasket(){
        _dishes.value?.let { addBasketServiceUseCase.execute(dishes = it) }
    }

}
