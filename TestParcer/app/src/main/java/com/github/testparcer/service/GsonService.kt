package com.github.testparcer.service

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.testparcer.models.GsonModel
import com.github.testparcer.models.NewsModel
import com.google.gson.Gson
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.net.URL
import java.text.DateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.util.*
import javax.net.ssl.HttpsURLConnection

class GsonService(private val fragment: Fragment) {

    private fun connectionJSON(): String {
        val url = URL("https://api2.kiparo.com/static/it_news.json")
        val httpsURLConnection: HttpsURLConnection = url.openConnection() as HttpsURLConnection
        val data = httpsURLConnection.inputStream.bufferedReader().use {
            it.readText()
        }
        return data
    }

    fun downloadFileJSON() {
        try {
            Thread {
                val file = File(fragment.requireContext().filesDir,"jsonObject.json")
                FileOutputStream(file).use {
                    val bytes = connectionJSON().toByteArray()
                    it.write(bytes)
                }
                fragment.requireActivity().runOnUiThread(Runnable {
                    Toast.makeText(fragment.requireContext(), "JSON file download successful", Toast.LENGTH_SHORT)
                        .show()
                })
            }.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun getFileJSON(): String {
        val file = File(fragment.requireContext().filesDir,"jsonObject.json")
        val data = FileInputStream(file).use {
            String(it.readBytes())
        }
        return data
    }

    fun gsonTest(): GsonModel {
        val file = File(fragment.requireContext().filesDir, "jsonObject.json")
        val data = FileInputStream(file).use {
            String(it.readBytes())
        }
        val gsonString = Gson().fromJson(data, GsonModel::class.java)
        return gsonString
    }

    private fun dataSetup(newsModel: NewsModel): LocalDate{
        val formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
        val date = LocalDate.parse(newsModel.date, formatter)
        return date
    }

}