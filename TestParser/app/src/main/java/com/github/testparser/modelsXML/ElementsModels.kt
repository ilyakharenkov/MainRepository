package com.github.testparser.modelsXML

data class ElementsModels(
    val date: DateModels?,
    val description: DescriptionModels?,
    val id: IdModels?,
    val keywords: List<KeywordsModels>?,
    val title: TitleModels?,
    val visible: VisibleModels?
){
    override fun toString(): String {
        return "\t$date" +
                "\t$description" +
                "\t$id" +
                "\t$title" +
                "\t$visible"
    }
}
