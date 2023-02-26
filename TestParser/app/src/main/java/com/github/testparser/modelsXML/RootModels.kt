package com.github.testparser.modelsXML

data class RootModels(
    val location: String,
    val name: String,
    val news: NewsModels?
){
    override fun toString(): String {
        return "Location: $location\n" +
                "Name: $name\n" +
                "News: \n$news"
    }
}
