package com.ly.mvvmproject.base

import android.app.Application
import com.ly.mvvmbase.net.NetRetroift2
import com.ly.mvvmproject.net.interceptor.TokenInterceptor

class MvvmApplication :Application() {
    companion object {
        var sIntance: MvvmApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        sIntance = this
        NetRetroift2.mInstance.apply {
            addInterceptor(TokenInterceptor())
            setTimeOutTime(5L)
            baseUrl = AppConfig.BASE_URL
        }.initConfig()
    }
}