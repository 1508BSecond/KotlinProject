package com.pc.mykotlin.JiaoZi.cache

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jaeger.library.StatusBarUtil
import com.pc.mykotlin.R
import kotlinx.android.synthetic.main.activity_cache_list.*

class CacheListActivity : AppCompatActivity() {

    var list:List<CacheBean> = ArrayList<CacheBean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cache_list)
        StatusBarUtil.setTranslucent(this)
        //点击返回界面
        cache_iv_back.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                finish()
            }
        })

        //设置给Rlv值
        cache_rlv.layoutManager = LinearLayoutManager(this)
        //设置适配器
        var adapter = CacheAdapter(this,list)
        cache_rlv.adapter = adapter

    }
}
