package com.example.deliveryprojecttest.presentation.screens.fragment

import android.location.Geocoder
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.deliveryprojecttest.Di
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.FragmentMainScreenBinding
import com.example.deliveryprojecttest.presentation.screens.adapter.mainscreen.MainScreenAdapter
import com.example.deliveryprojecttest.presentation.screens.mvvm.MainViewModel
import com.example.deliveryprojecttest.presentation.screens.mvvm.MainViewModelFactory
import java.text.SimpleDateFormat
import java.util.Date
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
    }

    private fun initAdapter() {
        adapter = MainScreenAdapter(click = {
            findNavController()
                .navigate(R.id.action_mainScreenFragment_to_categoryScreenFragment, bundleOf("KEY" to it))
        })
        binding.rcViewMainScreen.layoutManager = LinearLayoutManager(requireContext())
        binding.rcViewMainScreen.adapter = adapter
    }

    private fun initObserver() {
        viewModel.list.observe(viewLifecycleOwner) {
            adapter.listCategories = it
        }
    }

    private fun initDataCalendar() {
        val formatter = SimpleDateFormat("dd MMM, yyyy", Locale.getDefault())
        val time = formatter.format(Date())
        binding.locationData.text = time
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

    private fun test(lat: Double, long: Double) {
        val geoCoder = Geocoder(requireContext(), Locale.getDefault())
        geoCoder.getFromLocation(lat, long, 1) {
            binding.locationCity.text = it[0].adminArea
        }
    }


}



