package com.ly.mvvmbase.net

class SuccessData  {

    var url:String?=null
    var data:BaseResponse<*>?=null
    var pageIndex:Int = 0
    constructor(url:String,data:BaseResponse<*>,pageIndex:Int){
        this.url = url
        this.data = data
        this.pageIndex = pageIndex
    }
    constructor(url:String,data:BaseResponse<*>){
        this.url = url
        this.data = data
    }
}