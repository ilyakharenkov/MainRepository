package com.example.deliveryprojecttest.presentation.screens

import android.location.Geocoder
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.deliveryprojecttest.Di
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.FragmentMainScreenBinding
import com.example.deliveryprojecttest.presentation.screens.adapter.MainScreenAdapter
import com.example.deliveryprojecttest.presentation.screens.mvvm.MainViewModel
import com.example.deliveryprojecttest.presentation.screens.mvvm.MainViewModelFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class MainScreenFragment : Fragment(R.layout.fragment_main_screen) {

    private lateinit var binding: FragmentMainScreenBinding
    private lateinit var adapter: MainScreenAdapter

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory(getCategoriesUseCase = Di.getCategoriesUseCase)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainScreenBinding.bind(view)
        initAdapter()
        initObserver()
        initPhoto()
        initDataCalendar()
        location()
    }

    private fun initAdapter() {
        adapter = MainScreenAdapter()
        binding.rcViewMainScreen.layoutManager = LinearLayoutManager(requireContext())
        binding.rcViewMainScreen.adapter = adapter
    }

    private fun initObserver() {
        viewModel.list.observe(viewLifecycleOwner) {
            adapter.listCategories = it
        }
    }

    private fun location() {
        test(lat = 55.751244, long = 37.618423)
    }

    private fun test(lat: Double, long: Double) {
        val geoCoder = Geocoder(requireContext(), Locale.getDefault())
        geoCoder.getFromLocation(lat, long, 1) {
            binding.locationCity.text = it[0].adminArea
        }
    }

    private fun initDataCalendar() {
        val data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMM, yyyy"))
        binding.locationData.text = data
    }

    private fun initPhoto() {
        Glide.with(requireContext())
            .load("https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8ZmFjZXxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60")
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .circleCrop()
            .error(R.drawable.account_image)
            .into(binding.userPhoto)
    }
}



