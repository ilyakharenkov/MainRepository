package com.example.deliveryprojecttest.presentation.screens.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.deliveryprojecttest.R
import com.example.deliveryprojecttest.databinding.FragmentProductScreenBinding
import com.example.deliveryprojecttest.domain.model.TestModel

class ProductScreenFragment : DialogFragment(R.layout.fragment_product_screen) {

    private lateinit var binding: FragmentProductScreenBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductScreenBinding.bind(view)
        initButton()
        resultOfCategoryScreen()
    }

    private fun initButton() {
        binding.btnCancel.setOnClickListener {
            dialog?.cancel()
        }
        binding.btnAddBasket.setOnClickListener {

        }
    }

    private fun resultOfCategoryScreen() {
        val i = arguments?.getParcelable("TEST", TestModel::class.java)
        if (i != null) {
            initTestModel(testModel = i)
        }
    }

    private fun initTestModel(testModel: TestModel) {
        Glide
            .with(binding.imageDishes.context)
            .load(testModel.image_url)
            .error(R.drawable.ic_food_place_holder)
            .into(binding.imageDishes)
        binding.tvNameDishes.text = testModel.name
        binding.tvPrice.text = testModel.price.toString()
        binding.tvWeight.text = testModel.weight.toString()
        binding.tvDescription.text = testModel.description
    }

    companion object {

        fun newInstance(testModel: TestModel): ProductScreenFragment{
            val args = bundleOf("TEST" to testModel)
            val fragment = ProductScreenFragment()
            fragment.arguments = args
            return fragment
        }

        const val TAG_DIALOG = "TEST_TAG_DIALOG"
    }

}