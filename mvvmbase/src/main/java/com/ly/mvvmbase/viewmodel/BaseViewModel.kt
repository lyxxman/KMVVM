package com.ly.mvvmbase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.ly.mvvmbase.model.BaseModel
import com.ly.mvvmbase.net.ErrorData

/**
 * @author ly
 * @dscriprtion 基础viewmodel类
 * @date 2019年10月9日 11:22:51
 * @version 1.0.0
 */
abstract class BaseViewModel<T : BaseModel> : AndroidViewModel, BaseModel.OnGetDataListener {

    var model: T? = null

    var errorLiveData: MutableLiveData<ErrorData>? = null
    //初始化 model
    abstract fun initModel(): T

    constructor(application: Application) : super(application) {
        model = initModel()
        errorLiveData = MutableLiveData()
        model?.mOnGetDataListener = this
    }

    //回收相关对象
    override fun onCleared() {
        super.onCleared()
        //回收model
        model?.onCleard()
        model = null
    }


}