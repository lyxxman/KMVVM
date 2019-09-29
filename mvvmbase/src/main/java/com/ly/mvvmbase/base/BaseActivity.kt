package com.ly.mvvmbase.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


/**
 * @Package com.ly.kotlinmvp.base
 * @Description: 基础baseActivity
 * @author ly
 * @date 2018/5/11 15:57
 * @version V1.0
 */
abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        init()
    }

    abstract fun getLayoutId(): Int

    abstract fun init()



    override fun onDestroy() {
        super.onDestroy()
    }
}