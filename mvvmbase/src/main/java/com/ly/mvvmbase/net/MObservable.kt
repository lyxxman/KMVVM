package com.ly.mvvmbase.net

import com.ly.mvvmbase.model.BaseModel
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
class MObservable<T,R:ImExceptionHandler> : ApiObserver {
    var observable: Observable<BaseResponse<T>>? = null

    var loadUrl: String = ""
    var pageIndex: Int = 0
    var exceptionHandler:ImExceptionHandler ?=null
    constructor(ob: Observable<BaseResponse<T>>,e:R) {
        this.observable = ob
    exceptionHandler = e
    }

    init {
        observable?.let {
            it.subscribeOn(Schedulers.io())
            it.observeOn(AndroidSchedulers.mainThread())
        }

    }

    override fun requeest(
        mCompositeDisposable: CompositeDisposable?,
        mOnGetDataListener: BaseModel.OnGetDataListener?
    ) {
        observable?.subscribe(object : Observer<BaseResponse<T>> {
            override fun onNext(t: BaseResponse<T>) {
                if (pageIndex > 0) {
                    mOnGetDataListener?.onResponse(SuccessData(loadUrl, t, pageIndex))
                } else
                    mOnGetDataListener?.onResponse(SuccessData(loadUrl, t))
            }

            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
                mCompositeDisposable?.add(d)
            }

            override fun onError(e: Throwable) {
                if (pageIndex > 0) {
                    mOnGetDataListener?.onError(exceptionHandler?.let {
                     it.onPagingError(loadUrl, e, pageIndex)
                    })
                } else {
                    mOnGetDataListener?.onError(exceptionHandler?.let {
                        it.onError(loadUrl, e)
                    })
                }

            }
        })
    }


}