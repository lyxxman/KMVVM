package com.ly.mvvmbase.net

/**
 * 基础数据返回类
 */
class BaseResponse<T> {
    var code: Int = 0
    var message: String? = null
    var data:T? = null
constructor(){

}
    constructor(code: Int, message: String, data: T) {
        this.data = data
    }

    constructor(code: Int, message: String) {
        this.code = code
        this.message = message
    }
}