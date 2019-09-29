package com.ly.mvvmbase.base

import android.app.Application
import com.ly.mvvmbase.net.NetRetroift2
import com.ly.mvvmbase.net.interceptor.TokenInterceptor

class BaseApplication : Application() {
    companion object {
        var sIntance: BaseApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        sIntance = this
        NetRetroift2.mInstance.apply {
            addInterceptor(TokenInterceptor())
            setTimeOutTime(5L)
        }.initConfig()
    }
}