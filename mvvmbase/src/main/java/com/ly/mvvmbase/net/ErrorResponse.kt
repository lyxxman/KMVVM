package com.ly.mvvmbase.net

class ErrorResponse {
    var url: String? = null
    var errorResponse: BaseResponse<*>? = null

    constructor(url:String,errorResponse:BaseResponse<*>){
        this.url =url
        this.errorResponse = errorResponse
    }
}