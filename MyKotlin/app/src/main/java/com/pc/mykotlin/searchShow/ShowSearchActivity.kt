package com.pc.mykotlin.searchShow

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jaeger.library.StatusBarUtil
import com.pc.mykotlin.JiaoZi.JiaoZiActivity
import com.pc.mykotlin.R
import com.pc.mykotlin.searchShow.adapter.SearchListAdapter
import com.pc.mykotlin.searchShow.bean.SearchBean
import com.pc.mykotlin.searchShow.presenter.SearchPresenter
import com.pc.mykotlin.searchShow.view.SearchShowView
import kotlinx.android.synthetic.main.activity_show_search.*

class ShowSearchActivity : AppCompatActivity(),SearchShowView {

    var start:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_search)

        StatusBarUtil.setTransparent(this)
        //点击销毁界面
        search_show_back.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                finish()
            }

        })

        //得到传过来的值
        val etValue = intent.getStringExtra("etValue")
        //设置标题栏
        search_show_name.text = "'"+etValue+"' 相关"

        //关联
        var p:SearchPresenter = SearchPresenter(this)
        p.pm(10,etValue,start)

    }

    //重写数据接口
    override fun searchShow(searchBean: SearchBean) {
        //设置数据
        val itemList = searchBean.itemList
        //给rlv
        show_rlv.layoutManager = LinearLayoutManager(this)
        //设置适配器
        var adapter = SearchListAdapter(this,itemList!!)
        show_rlv.adapter = adapter

        //点击跳转到播放界面
        adapter.setOnItemSearchListener(object :SearchListAdapter.OnItemSearchListener{
            override fun OnItemSearchClick(position: Int) {

                //得到传的值
                val category = searchBean.itemList?.get(position)?.data?.category

                var i: Intent = Intent(this@ShowSearchActivity,JiaoZiActivity::class.java)
                i.putExtra("category",category)
                i.putExtra("position",""+position)
                startActivity(i)
                finish()
            }

        })


    }

}
