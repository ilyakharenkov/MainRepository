package com.example.deliveryprojecttest.presentation.screens.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
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
        initButton()
        initAdapterDishes()
        initAdapterTeg()
        initObserver()
        initCategoryName()
        initPhoto()
    }

    private fun initButton() {
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initAdapterDishes() {
        adapterDishes = CategoryScreenDishesAdapter(click = {
            ProductScreenFragment.newInstance(it.id).show(
                childFragmentManager,
                ProductScreenFragment.TAG_DIALOG
            )
        })
        binding.rcViewDishes.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rcViewDishes.adapter = adapterDishes
    }

    private fun initAdapterTeg() {
        adapterTeg = CategoryScreenTegAdapter()
        binding.rcViewTeg.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rcViewTeg.adapter = adapterTeg
    }

    private fun initObserver() {
        viewModel.listDishes.observe(viewLifecycleOwner) {
            adapterDishes.list = it
        }
        viewModel.listTags.observe(viewLifecycleOwner) {
            adapterTeg.list = it
        }
    }

    private fun initCategoryName() {
        arguments?.getString(KEY_NAME_CATEGORY)?.let {
            viewModel.resultName(name = it)
        }
        viewModel.resultName.observe(viewLifecycleOwner) {
            binding.categoryName.text = it
        }
    }

    private fun initPhoto() {
        Glide.with(requireContext())
            .load("https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZmFjZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60")
            .circleCrop()
            .error(R.drawable.account_image)
            .into(binding.userPhoto)
    }

    companion object {
        const val KEY_NAME_CATEGORY = "KEY_NAME_CATEGORY"
    }


}