package com.ly.mvvmbase.net

class SuccessData  {

    var url:String?=null
    var data:BaseResponse<*>?=null

    constructor(url:String,data:BaseResponse<*>){
        this.url = url
        this.data = data
    }

}