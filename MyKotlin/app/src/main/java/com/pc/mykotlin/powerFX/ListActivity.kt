package com.pc.mykotlin.powerFX

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jaeger.library.StatusBarUtil
import com.pc.mykotlin.JiaoZi.JiaoZiActivity
import com.pc.mykotlin.R
import com.pc.mykotlin.powerFX.adapter.ListRlvAdapter
import com.pc.mykotlin.powerFX.bean.ListBean
import com.pc.mykotlin.powerFX.presenter.ListPresenter
import com.pc.mykotlin.powerFX.view.ListInfoView
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() ,ListInfoView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        StatusBarUtil.setTransparent(this)
        //点击返回
        list_iv_back.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                finish()
            }

        })

        //得到传过来的值
        val name = intent.getStringExtra("name")
        //设置标题
        list_tv_name.text = name

        var p:ListPresenter = ListPresenter(this)
        p.pm(name,"26868b32e808498db32fd51fb422d00175e179df",83)

    }

    //实现数据接口
    override fun listShow(listBean: ListBean) {
        val itemList = listBean.itemList

        //设置rlv数据
        list_rlv.layoutManager = LinearLayoutManager(this)
        var adapter = ListRlvAdapter(this,itemList!!)
        list_rlv.adapter = adapter

        //设置点击跳转
        adapter.setOnItemListListener(object : ListRlvAdapter.OnItemListListener{
            override fun OnItemListClick(position: Int) {
                //获取传的值
                val category = listBean.itemList?.get(position)?.data?.category
                if(category.equals(null)){
                    return
                }
                //Intent跳转传值
                var i: Intent = Intent(this@ListActivity,JiaoZiActivity::class.java)
                i.putExtra("category",category)
                i.putExtra("position",""+position)
                startActivity(i)
            }

        })
    }

    /*override fun getPresenter(): ListPresenter? {
        return ListPresenter(this)
    }

    override fun initData() {
        presenter!!.pm("时尚","26868b32e808498db32fd51fb422d00175e179df",83)
    }

    override fun initView() {
    }

    override fun layoutId(): Int {
        return R.layout.activity_list
    }*/

}
