package com.ly.mvvmproject.net.model

import com.ly.mvvmbase.model.BaseModel
import com.ly.mvvmbase.net.NetRetroift2
import com.ly.mvvmproject.net.bean.MainData
import com.ly.mvvmproject.net.request.MObservable
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
        MObservable(observable).apply {
            pageIndex = mainLsPageIndex
            loadUrl = url
        }.requeest(mCompositeDisposable,mOnGetDataListener)
    }


}

