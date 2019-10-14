package com.ly.mvvmproject.net.exception

import com.ly.mvvmbase.net.ErrorData
import com.ly.mvvmbase.net.ImExceptionHandler
import com.ly.mvvmproject.R
import com.ly.mvvmproject.utils.StringUtil
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * @author ly
 * @name 异常拦截处理类
 * @version 1.0.0
 * @date 2019年10月9日 11:15:52
 */
object ExceptionHandler :ImExceptionHandler {
    const val APP_ERROR = -1 //app错误
    const val UNET_ERROR = -2 //无网络 网络错误

    override fun onPagingError(url: String, e: Throwable?, pageIndex: Int): ErrorData {
        if (e is ConnectException || e is UnknownHostException || e is SocketTimeoutException || e is HttpException) run {
            return ErrorData(
                url,
                UNET_ERROR, StringUtil.getString(R.string.app_error), pageIndex
            )
        }
        return ErrorData(
            url,
            APP_ERROR, StringUtil.getString(R.string.app_error), pageIndex
        )
    }
}