package com.github.testparser.modelsXML

data class NewsModels(
    val element: List<ElementsModels>?
){

    override fun toString(): String {
        return "$element\n"
    }

}
