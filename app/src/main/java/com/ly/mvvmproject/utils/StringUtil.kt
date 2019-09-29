package com.ly.mvvmproject.utils

import com.ly.mvvmproject.base.MvvmApplication


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
        return MvvmApplication.sIntance!!.resources.getString(id)
    }
}