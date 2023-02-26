package com.github.testparser.modelsGson


data class NewsModel(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val keywords: List<String>,
    val visible: Boolean
) {

    override fun toString(): String {
        return "\n\nid: $id\n" +
                "\t\ttitle: $title\n" +
                "\t\tdescription: $description\n" +
                "\t\tdate: $date\n" +
                "\t\tkeywords: $keywords\n" +
                "\t\tvisible: $visible"
    }

}

