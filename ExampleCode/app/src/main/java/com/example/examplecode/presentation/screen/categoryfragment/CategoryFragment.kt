package com.example.examplecode.presentation.screen.categoryfragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examplecode.R
import com.example.examplecode.databinding.FragmentCategoryBinding
import com.example.examplecode.domain.model.Category

class CategoryFragment : Fragment(R.layout.fragment_category) {

    private lateinit var binding: FragmentCategoryBinding

    private lateinit var adapter: CategoryAdapter

    private var listCategory = listOf<Category>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoryBinding.bind(view)
        initAdapter()
        initObserver()
    }

    private fun initAdapter(){
        adapter = CategoryAdapter {
            Toast.makeText(requireContext(), it.name, Toast.LENGTH_SHORT).show()
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun initObserver(){
        listCategory = (0..5).map {
            Category(id = it, name = "Name $it")
        }
        adapter.listCategory = listCategory
    }

}