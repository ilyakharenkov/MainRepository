package com.github.testparser.service

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.testparser.modelsGson.GsonModel
import com.github.testparser.modelsGson.NewsModel
import com.google.gson.Gson
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.net.URL
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.net.ssl.HttpsURLConnection

class GsonService(private val fragment: Fragment) {

    //Метод класса File без запроса разрешения, можно использовать cacheDir как временное хранилище
    private fun fileGson(): File{
        return File(fragment.requireContext().filesDir, "jsonObject.json")
    }


    //Получение данных по URL
    private fun connectionJSON(): String {
        val url = URL("https://api2.kiparo.com/static/it_news.json")
        val httpsURLConnection = url.openConnection() as HttpsURLConnection
        val data = httpsURLConnection.inputStream.bufferedReader().use {
            it.readText()
        }
        return data
    }

    //FileOutputStream записывает содержимое файла
    fun downloadFileJSON() {
        try {
            Thread {
                FileOutputStream(fileGson()).use {
                    val bytes = connectionJSON().toByteArray()
                    it.write(bytes)
                }
                fragment.requireActivity().runOnUiThread(Runnable {
                    Toast.makeText(
                        fragment.requireContext(),
                        "JSON file download successful",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                })
            }.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    //FileInputStream читает содержимое файла
    fun openFileJSON(): String {
        val data = FileInputStream(fileGson()).use {
            String(it.readBytes())
        }
        return data
    }

    fun gsonParses(): GsonModel {
        return Gson().fromJson(openFileJSON(), GsonModel::class.java)
    }

    //Попытка переформатировать время
    private fun dataSetup(newsModel: NewsModel): LocalDate {
        val formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
        val date = LocalDate.parse(newsModel.date, formatter)
        return date
    }


}