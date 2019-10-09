package com.ly.mvvmproject.net.request

import com.ly.mvvmbase.model.BaseModel
import com.ly.mvvmbase.net.BaseResponse
import com.ly.mvvmbase.net.SuccessData
import com.ly.mvvmproject.net.exception.ExceptionHandler
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 *
 * @name 自定义rxjava观察者对象
 * @author ly
 * @version 1.0.0
 * @descrpition 封装和retrofit2.0请求返回处理
 */
class MObservable<T> : Observable<BaseResponse<T>>() {
    var loadUrl: String = ""
    var pageIndex: Int = 0
    override fun subscribeActual(observer: Observer<in BaseResponse<T>>?) {
    }

    init {
        subscribeOn(Schedulers.io())
        observeOn(AndroidSchedulers.mainThread())
    }

    fun subscribeX(
        mCompositeDisposable: CompositeDisposable?,
        mOnGetDataListener: BaseModel.OnGetDataListener?
    ) {
        subscribe(object : Observer<BaseResponse<T>> {
            override fun onNext(t: BaseResponse<T>) {
                if (pageIndex>0){
                    mOnGetDataListener?.onResponse(SuccessData(loadUrl, t,pageIndex))
                }else
                mOnGetDataListener?.onResponse(SuccessData(loadUrl, t))
            }

            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
                mCompositeDisposable?.add(d)
            }

            override fun onError(e: Throwable) {
                if (pageIndex>0){
                    mOnGetDataListener?.onError(ExceptionHandler.onError(loadUrl, e,pageIndex))
                }else{
                    mOnGetDataListener?.onError(ExceptionHandler.onError(loadUrl, e))
                }

            }
        })
    }
}