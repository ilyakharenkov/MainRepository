package com.github.testparcer.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.testparcer.databinding.FragmentParserBinding
import com.github.testparcer.service.GsonService
import com.github.testparcer.service.XmlService
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class TestFragmentParser : Fragment() {

    private lateinit var binding: FragmentParserBinding
    private val gsonService = GsonService(fragment = this)
    private val xmlService = XmlService(fragment = this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentParserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        executeButton()
    }

    private fun executeButton() {
        binding.btnDownloadGSON.setOnClickListener {
            gsonService.downloadFileJSON()
        }
        binding.btnOpenFileGSON.setOnClickListener {
            binding.tvResult.text = gsonService.getFileJSON()
        }
        binding.btnParserGSON.setOnClickListener {
            binding.tvResult.text = gsonService.gsonTest().toString()
        }
        binding.btnDownloadXML.setOnClickListener {
            xmlService.downloadFileXML()
        }
        binding.btnOpenFileXML.setOnClickListener {
            binding.tvResult.text = xmlService.getFileXML()
        }
        binding.btnParserFileXML.setOnClickListener {

        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): TestFragmentParser {
            return TestFragmentParser()
        }
    }
}

