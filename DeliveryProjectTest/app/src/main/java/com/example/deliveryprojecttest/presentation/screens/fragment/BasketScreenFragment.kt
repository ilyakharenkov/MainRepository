package com.example.deliveryprojecttest.presentation.screens.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deliveryprojecttest.Di
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.FragmentBasketScreenBinding
import com.example.deliveryprojecttest.domain.model.Dishes
import com.example.deliveryprojecttest.presentation.screens.adapter.basketscreen.BasketScreenAdapter
import com.example.deliveryprojecttest.presentation.screens.mvvm.BasketViewModel
import com.example.deliveryprojecttest.presentation.screens.mvvm.BasketViewModelFactory

class BasketScreenFragment : Fragment(R.layout.fragment_basket_screen) {

    private lateinit var adapter: BasketScreenAdapter

    private var testList: List<Dishes> = emptyList()

    private val viewModel: BasketViewModel by viewModels{
        BasketViewModelFactory()
    }
    private lateinit var binding: FragmentBasketScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBasketScreenBinding.bind(view)
        initTestList()
        initAdapter()
        initObserver()
        initButton()
    }

    private fun initAdapter(){
        adapter = BasketScreenAdapter()
        binding.rcViewBasket.layoutManager = LinearLayoutManager(requireContext())
        binding.rcViewBasket.adapter = adapter
    }

    private fun initTestList(){
        testList = (0..2).map {
            Dishes(
                id = it,
                name = "name $it",
                price = it + 100,
                weight = it + 10,
                description = "description $it",
                image_url = "",
                tegs = listOf()
            )
        }
    }

    private fun initObserver(){
        adapter.list = testList
    }

    private fun initButton(){
        binding.btnBie.setOnClickListener {

        }
    }



}