package com.ly.mvvmproject.net.service

import com.ly.mvvmbase.net.BaseResponse
import com.ly.mvvmproject.net.request.MObservable
import com.ly.mvvmproject.net.bean.MainData
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MainService {

    @FormUrlEncoded
    @POST("main")
    fun getDataList(@Field("name") name: String,@Field("pageIndex")pageIndex:Int,@Field("pageSize")pageSize:Int): MObservable<MutableList<MainData>>


}