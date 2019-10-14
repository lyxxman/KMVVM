package com.ly.mvvmbase.net

/**
 * @author ly
 * @description 异常处理接口
 * @date 2019年10月14日 16:25:51
 */
interface ImExceptionHandler {

    fun onError(url: String, e: Throwable?): ErrorData = onPagingError(url, e, 0)

    fun onPagingError(url: String, e: Throwable?, pageIndex: Int): ErrorData
}