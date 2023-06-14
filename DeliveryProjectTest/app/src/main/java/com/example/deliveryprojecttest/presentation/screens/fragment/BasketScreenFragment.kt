package com.example.deliveryprojecttest.presentation.screens.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.FragmentBasketScreenBinding
import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.presentation.screens.adapter.basketscreen.BasketScreenAdapter
import com.example.deliveryprojecttest.presentation.screens.mvvm.BasketViewModel
import com.example.deliveryprojecttest.presentation.screens.mvvm.BasketViewModelFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class BasketScreenFragment : Fragment(R.layout.fragment_basket_screen) {

    private lateinit var adapter: BasketScreenAdapter

    private var testList: List<Dishes> = emptyList()

    private val viewModel: BasketViewModel by viewModels {
        BasketViewModelFactory()
    }
    private lateinit var binding: FragmentBasketScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBasketScreenBinding.bind(view)
        initAdapter()
        initObserver()
        initButton()
        initDataCalendar()
        initPhoto()
    }

    private fun initAdapter() {
        adapter = BasketScreenAdapter()
        binding.rcViewBasket.layoutManager = LinearLayoutManager(requireContext())
        binding.rcViewBasket.adapter = adapter
    }

    private fun initObserver() {
        adapter.list = testList
    }

    private fun initButton() {
        binding.btnBie.setOnClickListener {

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
            .circleCrop()
            .error(R.drawable.account_image)
            .into(binding.userPhoto)
    }


}