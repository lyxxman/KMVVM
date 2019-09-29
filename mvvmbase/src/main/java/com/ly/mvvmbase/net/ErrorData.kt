package com.ly.mvvmbase.net

class ErrorData {

    var code: Int = 0
    var message: String? = null
    var url: String? = null

    constructor(url: String,code: Int, message: String) {
        this.code = code
        this.message = message
        this.url = url
    }

    constructor(code: Int, message: String) {
        this.code = code
        this.message = message
    }
}