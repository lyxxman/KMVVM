package com.ly.mvvmbase.model

import com.ly.mvvmbase.net.BaseResponse
import com.ly.mvvmbase.net.ErrorData
import com.ly.mvvmbase.net.SuccessData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseModel{
    //
    var mCompositeDisposable: CompositeDisposable? = null
    var mOnGetDataListener: OnGetDataListener? = null

    constructor() {
        mCompositeDisposable = CompositeDisposable()
    }

    //添加一个调用
    fun addSubscription(disposable: Disposable) {
        mCompositeDisposable?.add(disposable)
    }

    //清除请求
    open fun onCleard() {
        if (mCompositeDisposable?.isDisposed!!) {
            mCompositeDisposable?.clear()
        }
    }


    interface OnGetDataListener {

        fun onResponse(data:SuccessData)

        fun onError( data: ErrorData)

    }

}