package com.github.testparser.service

import androidx.fragment.app.Fragment
import com.github.testparser.modelsXML.*
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.File
import java.io.FileInputStream
import java.util.*

class MainXmlPullParser {

    fun parse(fragment: Fragment): RootModels {

        val file = File(fragment.requireContext().filesDir,"xmlObject.xml")
        val input = FileInputStream(file)
        val parser = XmlPullParserFactory.newInstance().newPullParser()
        parser.setInput(input, null)

        var eventType = parser.eventType
        val tags = Stack<String>()

        var locationText = ""
        var nameText = ""
        var dateText = ""
        var descriptionText = ""
        var idText = ""
        var elementText = ""
        var titleText = ""
        var visibleText = ""

        var rootModels: RootModels? = null
        var newsModels: NewsModels? = null
        var elementList = emptyList<ElementsModels>().toMutableList()
        var dateModels: DateModels? = null
        var descriptionModels: DescriptionModels? = null
        var idModels: IdModels? = null
        var keywordsModels = emptyList<KeywordsModels>().toMutableList()
        var titleModels: TitleModels? = null
        var visibleModels: VisibleModels? = null

        while (eventType != XmlPullParser.END_DOCUMENT) {
            when (eventType) {

                XmlPullParser.START_TAG -> { //ошибка из за одинаковых тэгов element
                    tags.push(parser.name)
                    when(parser.name){
                        "element" -> {
                            elementList = emptyList<ElementsModels>().toMutableList()
                            elementText = ""
                        }
                        "date" -> {
                            dateText = ""
                        }
                        "description" -> {
                            descriptionText = ""
                        }
                        "id" -> {
                            idText = ""
                        }
                        "title" -> {
                            titleText = ""
                        }
                        "visible" -> {
                            visibleText = ""
                        }
                    }
                }

                XmlPullParser.TEXT -> {
                    when(tags.peek()){
                        "location" -> {
                            locationText += parser.text
                        }
                        "name" -> {
                            nameText += parser.text
                        }
                        "date" -> {
                            dateText += parser.text
                        }
                        "description" -> {
                            descriptionText += parser.text
                        }
                        "id" -> {
                            idText += parser.text
                        }
                        "element" -> {
                            elementText += parser.text
                        }
                        "title" -> {
                            titleText += parser.text
                        }
                        "visible" -> {
                            visibleText += parser.text
                        }
                    }
                }

                XmlPullParser.END_TAG -> {
                    when(parser.name){
                        "root" -> {
                            rootModels = RootModels(location = locationText, name = nameText, news = newsModels)
                        }
                        "news" -> {
                            newsModels = NewsModels(element = elementList)
                        }
                        "element" -> {
                            elementList.add(ElementsModels(
                                date = dateModels,
                                description = descriptionModels,
                                id = idModels,
                                keywords = keywordsModels,
                                title = titleModels,
                                visible = visibleModels
                            ))
                        }
                        "date" -> {
                            dateModels = DateModels(date = dateText)
                        }
                        "description" -> {
                            descriptionModels = DescriptionModels(description = descriptionText)
                        }
                        "id" -> {
                            idModels = IdModels(id = idText)
                        }
                        "keywords" -> {
                            keywordsModels.add(KeywordsModels(element = elementText))
                        }
                        "title" -> {
                            titleModels = TitleModels(title = titleText)
                        }
                        "visible" -> {
                            visibleModels = VisibleModels(visible = visibleText)
                        }
                    }
                }
            }
            eventType = parser.next()
        }

        input.close()

        return rootModels ?: throw Exception()
    }

}