package com.example.deliveryprojecttest.presentation.screens.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.deliveryprojecttest.Di
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.FragmentProductScreenBinding
import com.example.deliveryprojecttest.presentation.screens.mvvm.ProductViewModel
import com.example.deliveryprojecttest.presentation.screens.mvvm.ProductViewModelFactory

class ProductScreenFragment : DialogFragment(R.layout.fragment_product_screen) {

    private lateinit var binding: FragmentProductScreenBinding
    private val viewModel: ProductViewModel by viewModels {
        ProductViewModelFactory(
            basketServiceUseCase = Di.basketServiceUseCase,
            getDishesUseCase = Di.getDishesUseCase
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductScreenBinding.bind(view)
        initButton()
        resultOfCategoryScreen()
        fillViewComponent()
    }

    private fun initButton() {
        binding.btnCancel.setOnClickListener {
            dialog?.cancel()
        }
        binding.btnAddBasket.setOnClickListener {
            viewModel.addDishesInBasket()
        }
    }

    private fun resultOfCategoryScreen() {
        val id = arguments?.getInt(KEY_ID)
        if (id != null) {
            viewModel.getById(id = id)
        }
    }

    private fun fillViewComponent() {
        viewModel.dishes.observe(viewLifecycleOwner) {
            Glide
                .with(binding.imageDishes.context)
                .load(it.image_url)
                .error(R.drawable.ic_food_place_holder)
                .into(binding.imageDishes)
            binding.tvNameDishes.text = it.name
            binding.tvPrice.text = it.price.toString()
            binding.tvWeight.text = it.weight.toString()
            binding.tvDescription.text = it.description
        }
    }

    companion object {
        fun newInstance(id: Int): ProductScreenFragment {
            val args = bundleOf(KEY_ID to id)
            val fragment = ProductScreenFragment()
            fragment.arguments = args
            return fragment
        }
        const val TAG_DIALOG = "TEST_TAG_DIALOG"
        const val KEY_ID = "KEY_ID"
    }

}