package com.ly.mvvmproject.net.model

import com.ly.mvvmbase.model.BaseModel
import com.ly.mvvmbase.net.NetRetroift2
import com.ly.mvvmproject.net.service.MainService

open class MainModel : BaseModel {
    var mainService: MainService? = null
    var mainLsPageSize = 20
    var mainLsPageIndex = 1

    constructor(
        mainService: MainService = NetRetroift2.mInstance.createService(MainService::class.java)
    )


    fun getMainList(url: String, name: String, loadMore: Boolean) {
        mainLsPageIndex = if (loadMore) { +1 } else { 1}
        val observable = mainService!!.getDataList(name, mainLsPageIndex, mainLsPageSize)
        observable.apply {
            loadUrl = url
            pageIndex = mainLsPageIndex
        }.subscribeX(mCompositeDisposable, mOnGetDataListener)
    }


}

