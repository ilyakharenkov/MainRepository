package com.example.deliveryprojecttest.presentation.screens.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.deliveryprojecttest.domain.usecase.GetCategoriesUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val getCategoriesUseCase: GetCategoriesUseCase) : ViewModel() {

    private val _photo = MutableLiveData<String>()
    val photo: LiveData<String> = _photo

    init {
        testPhoto()
    }

    private fun testPhoto(){
        viewModelScope.launch {
            _photo.value = getCategoriesUseCase.execute().сategories[1].image_url
        }
    }


}