package com.ly.mvvmproject.net.service

import com.ly.mvvmbase.net.BaseResponse
import com.ly.mvvmproject.net.request.MObservable
import com.ly.mvvmproject.net.bean.MainData
import io.reactivex.Observable
import retrofit2.http.*

interface MainService {

    @GET("bill/getBills")
    fun getAllBill(@Query("pageIndex") pageIndex: Int, @Query("pageSize") pageSize: Int): Observable<BaseResponse<MutableList<MainData>>>


}