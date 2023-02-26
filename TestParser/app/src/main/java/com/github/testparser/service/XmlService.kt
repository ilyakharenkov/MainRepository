package com.github.testparser.service

import android.widget.Toast
import androidx.fragment.app.Fragment
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class XmlService(private val fragment: Fragment) {

    //Экземпляр класса File без запроса разрешения, можно использовать cacheDir как временное хранилище
    private fun fileXml(): File {
        return File(fragment.requireContext().filesDir, "xmlObject.xml")
    }

    //Получение данных по URL
    private fun connectionXML(): String {
        val url = URL("https://api2.kiparo.com/static/it_news.xml")
        val httpsURLConnection = url.openConnection() as HttpsURLConnection
        val data = httpsURLConnection.inputStream.bufferedReader().use {
            it.readText()
        }
        return data
    }


    //FileOutputStream записывает содержимое файла
    fun downloadFileXML() {
        try {
            Thread {
                FileOutputStream(fileXml()).use {
                    val bytes = connectionXML().toByteArray()
                    it.write(bytes)
                }
                fragment.requireActivity().runOnUiThread(Runnable {
                    Toast.makeText(
                        fragment.requireContext(),
                        "XML file download successful",
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
    fun openFileXML(): String {
        val data = FileInputStream(fileXml()).use {
            String(it.readBytes())
        }
        return data
    }
}