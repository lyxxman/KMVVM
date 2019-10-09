package com.ly.mvvmbase.net

/**
 * @author ly
 * @description 成果结果返回封装类
 * @date 2019年10月9日 11:22:00
 * @version 1.0.0
 */
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