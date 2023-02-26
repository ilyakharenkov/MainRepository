package com.github.testparser.modelsXML

data class DescriptionModels(
    val description: String
){
    override fun toString(): String {
        return "$description\n"
    }
}
