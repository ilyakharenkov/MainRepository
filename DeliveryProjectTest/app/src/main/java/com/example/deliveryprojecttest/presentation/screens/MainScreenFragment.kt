package com.example.deliveryprojecttest.presentation.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.deliveryprojecttest.Di
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.FragmentMainScreenBinding
import com.example.deliveryprojecttest.presentation.screens.mvvm.MainViewModel
import com.example.deliveryprojecttest.presentation.screens.mvvm.MainViewModelFactory

class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {

    private lateinit var binding: FragmentMainScreenBinding
    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(getCategoriesUseCase = Di.getCategoriesUseCase)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainScreenBinding.bind(view)
    }

//    private fun test() {
//        viewModel.photo.observe(viewLifecycleOwner) {
//            Glide
//                .with(requireContext())
//                .load(it)
//                .placeholder(R.drawable.account_image)
//                .error(R.drawable.account_image)
//                .into(binding.imageBackground)
//        }
//    }

}