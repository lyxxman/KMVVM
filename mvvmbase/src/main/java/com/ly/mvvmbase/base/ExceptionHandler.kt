package com.ly.mvvmbase.base

import android.icu.text.IDNA
import com.ly.mvvmbase.R
import com.ly.mvvmbase.net.BaseResponse
import com.ly.mvvmbase.net.ErrorData
import com.ly.mvvmbase.utils.StringUtil
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

object ExceptionHandler {
    const val APP_ERROR = -1 //app错误
    const val UNET_ERROR = -2 //无网络 网络错误

    fun onError(url:String,e: Throwable?): ErrorData {
        if (e is ConnectException || e is UnknownHostException || e is SocketTimeoutException || e is HttpException) run {
            return ErrorData(url,UNET_ERROR, StringUtil.getString(R.string.app_error))
        }
        return ErrorData(url,APP_ERROR, StringUtil.getString(R.string.app_error))
    }


}