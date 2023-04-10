package com.example.testfragment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testfragment.databinding.FragmentOneBinding
import com.example.testfragment.databinding.FragmentThreeBinding

class ThreeFragment : Fragment() {

    private lateinit var binding: FragmentThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }
    companion object{
        @JvmStatic
        fun newInstance(): ThreeFragment {
            return ThreeFragment()
        }
    }


}