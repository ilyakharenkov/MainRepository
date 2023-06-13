package com.example.deliveryprojecttest.presentation.screens

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryprojecttest.Di
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.FragmentCategoryScreenBinding
import com.example.deliveryprojecttest.presentation.screens.adapter.categoryscreen.CategoryScreenDishesAdapter
import com.example.deliveryprojecttest.presentation.screens.adapter.categoryscreen.CategoryScreenTegAdapter
import com.example.deliveryprojecttest.presentation.screens.mvvm.CategoryViewModel
import com.example.deliveryprojecttest.presentation.screens.mvvm.CategoryViewModelFactory

class CategoryScreenFragment : Fragment(R.layout.fragment_category_screen) {

    private lateinit var binding: FragmentCategoryScreenBinding
    private lateinit var adapterDishes: CategoryScreenDishesAdapter
    private lateinit var adapterTeg: CategoryScreenTegAdapter

    private val viewModel: CategoryViewModel by viewModels {
        CategoryViewModelFactory(getDishesUseCase = Di.getDishesUseCase)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoryScreenBinding.bind(view)
        initAdapterDishes()
        initAdapterTeg()
        initObserver()
    }

    private fun initAdapterDishes(){
        adapterDishes = CategoryScreenDishesAdapter(click = {
            findNavController().navigate(R.id.action_categoryScreenFragment_to_productScreenFragment)
        })
        binding.rcViewDishes.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rcViewDishes.adapter = adapterDishes
    }

    private fun initAdapterTeg(){
        adapterTeg = CategoryScreenTegAdapter()
        binding.rcViewTeg.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rcViewTeg.adapter = adapterTeg
    }

    private fun initObserver(){
        viewModel.listDishes.observe(viewLifecycleOwner){
            adapterDishes.list = it
        }
        viewModel.listTags.observe(viewLifecycleOwner){
            adapterTeg.list = it
        }
    }
}