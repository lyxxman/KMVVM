package com.ly.mvvmbase.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * @author ly
 * @descriprition  基础fragment类
 * @version 1.0.0
 * @date 2019年10月9日 11:30:20
 */
abstract class BaseFragment : Fragment() {

    //布局layout的根布局
     var mView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mView != null) {
            reMoveOld()
        } else {
            if (getLayoutId() > 0) {
                mView = inflater.inflate(getLayoutId(), container, false)
                initView()
            }
        }
        return mView;
    }

     fun reMoveOld() {
         try {
             val parent = mView!!.parent as ViewGroup
             parent.removeView(mView)
         }catch (e:Exception){

         }

    }

    protected abstract fun getLayoutId(): Int

    fun initView() {//初始化数据

    }

    override fun onDestroy() {
        super.onDestroy()
        mView == null
    }
}