package com.ly.mvvmproject.net.model

import com.ly.mvvmbase.model.BaseModel
import com.ly.mvvmbase.net.NetRetroift2
import com.ly.mvvmbase.net.MObservable
import com.ly.mvvmproject.net.exception.ExceptionHandler
import com.ly.mvvmproject.net.service.MainService

open class MainModel : BaseModel {
    var mainService: MainService? = null
    var mainLsPageSize = 20
    var mainLsPageIndex = 1

    constructor(
    ) {
        mainService = NetRetroift2.mInstance.createService(MainService::class.java)
    }


    fun getMainList(url: String, loadMore: Boolean) {
        mainLsPageIndex = if (loadMore) {
            +1
        } else {
            1
        }
        val observable = mainService!!.getAllBill(mainLsPageIndex, mainLsPageSize)
        MObservable(observable,ExceptionHandler).apply {
            pageIndex = mainLsPageIndex
            loadUrl = url
        }.requeest(mCompositeDisposable,mOnGetDataListener)
    }


}

