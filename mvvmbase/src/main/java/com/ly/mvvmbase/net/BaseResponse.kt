package com.ly.mvvmbase.net

/**
 * @author ly
 * @description 基础数据返回类
 * @date 2019年10月9日 11:22:24
 * @version 1.0.0
 */
class BaseResponse<T> {
    var code: Int = 0
    var message: String? = null
    var data: T? = null


    constructor() {

    }

    constructor(code: Int, message: String, data: T) {
        this.data = data
        this.code = code
        this.message = message
    }
    constructor(code: Int, message: String) {
        this.code = code
        this.message = message
    }
}