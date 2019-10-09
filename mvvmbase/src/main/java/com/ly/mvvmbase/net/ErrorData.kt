package com.ly.mvvmbase.net

class ErrorData {

    var code: Int = 0
    var message: String? = null
    var url: String? = null
    var pageIndex: Int = 0
    constructor(url: String, code: Int, message: String) {
        this.code = code
        this.message = message
        this.url = url
    }

    constructor(url: String, code: Int, message: String, pageIndex: Int) {
        this.code = code
        this.message = message
        this.url = url
        this.pageIndex = pageIndex
    }

    constructor(code: Int, message: String) {
        this.code = code
        this.message = message
    }


}