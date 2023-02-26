package com.github.testparser.modelsXML

data class VisibleModels(
    val visible: String
) {
    override fun toString(): String {
        return "$visible\n"
    }
}
