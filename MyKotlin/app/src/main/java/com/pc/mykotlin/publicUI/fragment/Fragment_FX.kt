package com.pc.mykotlin.publicUI.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pc.mykotlin.R
import com.pc.mykotlin.powerFX.adapter.MyFxAdapter
import com.pc.mykotlin.powerFX.bean.FindBean
import com.pc.mykotlin.powerFX.presenter.FindPresenter
import com.pc.mykotlin.powerFX.view.FindView
import kotlinx.android.synthetic.main.frag_fx.*

/**
 * Created by pc on 2017/12/27.
 */

class Fragment_FX : Fragment(),FindView {
    //实现数据接口方法
    override fun findShow(findBean: List<FindBean>) {
        //展示数据
        /*Toast.makeText(activity,findBean.get(0).name,Toast.LENGTH_SHORT).show()
        Log.e("TAG-----",findBean.get(0).name)*/

        //设置rlv
        fxfrag_rlv.layoutManager = GridLayoutManager(activity,2)
        var adapter = MyFxAdapter(activity,findBean)
        fxfrag_rlv.adapter = adapter

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //关联
        var p:FindPresenter = FindPresenter(this)
        p.pm()

        return inflater!!.inflate(R.layout.frag_fx, container, false)
    }
}
