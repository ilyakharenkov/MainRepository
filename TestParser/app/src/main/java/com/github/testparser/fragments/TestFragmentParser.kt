package com.github.testparser.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.testparser.databinding.FragmentParserBinding
import com.github.testparser.service.GsonService
import com.github.testparser.service.MainXmlPullParser
import com.github.testparser.service.XmlService

class TestFragmentParser : Fragment() {

    private lateinit var binding: FragmentParserBinding

    private val gsonService = GsonService(fragment = this)
    private val xmlService = XmlService(fragment = this)

    private val mainXmlPullParser = MainXmlPullParser()

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
            binding.tvResult.text = gsonService.openFileJSON()
        }
        binding.btnParserGSON.setOnClickListener {
            binding.tvResult.text = gsonService.gsonParses().toString()
        }

        binding.btnDownloadXML.setOnClickListener {
            xmlService.downloadFileXML()
        }
        binding.btnOpenFileXML.setOnClickListener {
            binding.tvResult.text = xmlService.openFileXML()
        }
        binding.btnParserFileXML.setOnClickListener {
            binding.tvResult.text = mainXmlPullParser.parse(fragment = this).toString()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(): TestFragmentParser {
            return TestFragmentParser()
        }
    }
}

