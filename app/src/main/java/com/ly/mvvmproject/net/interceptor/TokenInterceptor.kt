package com.ly.mvvmproject.net.interceptor

import com.ly.mvvmproject.utils.PreferencesUtil
import com.ly.mvvmproject.utils.StringUtil
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * @author ly
 * @date 2019年9月24日 10:55:14
 * @description token拦截器
 */
class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        return if (isHaveInitToken(originalRequest)) {
            chain.proceed(originalRequest)
        } else {
            val authorised = originalRequest.newBuilder()
                .header("access-token", PreferencesUtil.getString(PreferencesUtil.SHARE_ACCESS_TOKEN, ""))
                .build()
            chain.proceed(authorised)
        }
    }

    private fun isHaveInitToken(originalRequest: Request?): Boolean {
        val token = originalRequest?.header("access-token")
        return !StringUtil.isEmpty(token)
    }
}