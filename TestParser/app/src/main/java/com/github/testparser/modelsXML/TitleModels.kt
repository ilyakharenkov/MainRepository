package com.github.testparser.modelsXML

data class TitleModels(
    val title: String?
){
    override fun toString(): String {
        return "$title\n"
    }
}
