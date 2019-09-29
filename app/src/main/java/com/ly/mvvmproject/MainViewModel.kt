package com.ly.mvvmproject

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.ly.mvvmbase.base.BaseApplication
import com.ly.mvvmbase.model.BaseModel
import com.ly.mvvmbase.model.BaseModel.*
import com.ly.mvvmbase.net.BaseResponse
import com.ly.mvvmbase.net.ErrorData
import com.ly.mvvmbase.net.SuccessData
import com.ly.mvvmbase.viewmodel.BaseViewModel
import com.ly.mvvmproject.net.bean.MainData
import com.ly.mvvmproject.net.model.MainModel
import javax.inject.Inject

/**
 * @author ly
 * @description 首页绑定Model和view层
 * @
 */
class MainViewModel(application: Application) : BaseViewModel<MainModel>(application),
    OnGetDataListener {

    var mainLiveData:MutableLiveData<MutableList<MainData>>?=null

    init {
        mainLiveData = MutableLiveData()
    }

    override fun initModel(): MainModel {
        return MainModel()
    }


    override fun onResponse(data: SuccessData) {


    }

    override fun onError(data: ErrorData) {

    }


    fun getMainLs(name:String){
        model?.getMainList("",name)
    }



}