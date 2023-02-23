package com.github.testparcer.service

import android.widget.Toast
import androidx.fragment.app.Fragment
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class XmlService(private val fragment: Fragment) {

    private fun connectionXML(): String {
        val url = URL("https://api2.kiparo.com/static/it_news.xml")
        val httpsURLConnection: HttpsURLConnection = url.openConnection() as HttpsURLConnection
        val data = httpsURLConnection.inputStream.bufferedReader().use {
            it.readText()
        }
        return data
    }

    fun downloadFileXML() {
        try {
            Thread {
                val file = File(fragment.requireContext().filesDir, "xmlObject.xml")
                FileOutputStream(file).use {
                    val bytes = connectionXML().toByteArray()
                    it.write(bytes)
                }
                fragment.requireActivity().runOnUiThread(Runnable {
                    Toast.makeText(fragment.requireContext(), "XML file download successful", Toast.LENGTH_SHORT)
                        .show()
                })
            }.start()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun getFileXML(): String {
        val file = File(fragment.requireContext().filesDir, "xmlObject.xml")
        val data = FileInputStream(file).use {
            String(it.readBytes())
        }
        return data
    }
}