package com.ly.mvvmbase.net

import com.ly.mvvmbase.model.BaseModel
import io.reactivex.disposables.CompositeDisposable

interface ApiObserver {
    fun requeest(mCompositeDisposable: CompositeDisposable?,
                 mOnGetDataListener: BaseModel.OnGetDataListener?)
}