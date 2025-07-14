package com.ellaclub.crequestdemo.bean.my_test.parse

data class ParseModel<T>(
    var code: Int = 0,
    var msg: String = "",
    var data: List<T>? = listOf()
)

open class BaseModel {
    val type: String = ""
}

class TextModel : BaseModel() {
    val text: String = ""
}

class ImageModel : BaseModel() {
    val desc: String = ""
    val url: String = ""
}

class LinkModel : BaseModel() {
    val comment: String = ""
    val link: String = ""
}



