package com.ly.mvvmbase.net

import com.ly.mvvm.base.AppConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetRetroift2 private constructor() {

    lateinit var retrofit: Retrofit
    private var okHttpClient: OkHttpClient? = null
    private var interceptors: MutableList<Interceptor> = mutableListOf()
    var timeOut = 5L


    companion object {

        val mInstance by lazy(mode = LazyThreadSafetyMode.NONE) {
            NetRetroift2()
        }
    }

    fun initConfig() {
        okHttpClient =
            OkHttpClient.Builder()
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
                .build()

        retrofit = Retrofit.Builder()
            .baseUrl(AppConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    /**
     * 添加拦截器
     */
    fun addInterceptor(interceptor: Interceptor) {
        interceptors.add(interceptor)
    }

    fun setTimeOutTime(timeOut: Long) {
        this.timeOut = timeOut
    }

    /**
     * 动态代理模式，创建请求接口类
     * @param tClass
     * @param <T>
     * @return
    </T> */
    fun <T> createService(tClass: Class<T>): T {
        if (retrofit == null) {
            initConfig()
        }
        return retrofit.create(tClass)
    }

}