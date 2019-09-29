package com.ly.mvvmbase.utils

import com.ly.mvvmbase.base.BaseApplication


object StringUtil {

    /**
     * 判断字符串是否为空
     */
    fun isEmpty(string: String?): Boolean {
        return string == null || string == ""
    }

    /**
     * 获取string资源下面的字符串
     */
    fun getString(id:Int):String{
        return BaseApplication.sIntance!!.resources.getString(id)
    }
}