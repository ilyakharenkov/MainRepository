package com.github.testparser.modelsGson

data class GsonModel(
    val name: String,
    val location: String,
    val news: MutableList<NewsModel>
) {
    override fun toString(): String {
        return "name: $name\n" +
                "location: $location\n" +
                "news: $news\n"
    }
}

