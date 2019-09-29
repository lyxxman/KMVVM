package com.ly.mvvmproject.net.model

import com.ly.mvvmproject.net.exception.ExceptionHandler
import com.ly.mvvmbase.model.BaseModel
import com.ly.mvvmbase.net.BaseResponse
import com.ly.mvvmbase.net.NetRetroift2
import com.ly.mvvmbase.net.SuccessData
import com.ly.mvvmproject.net.bean.MainData
import com.ly.mvvmproject.net.service.MainService
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

open class MainModel : BaseModel {
    var mainService: MainService? = null

    constructor(
        mainService: MainService = NetRetroift2.mInstance.createService(MainService::class.java)
    )


    fun getMainList(url:String,name: String) {
        val observable = mainService!!.getDataList(name)
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<BaseResponse<MutableList<MainData>>> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                    mCompositeDisposable!!.add(d)
                }

                override fun onNext(t: BaseResponse<MutableList<MainData>>) {
                    mOnGetDataListener?.onResponse(SuccessData(url,t))
                }

                override fun onError(e: Throwable) {
                   mOnGetDataListener?.onError(ExceptionHandler.onError(url,e))
                }
            })
    }

}