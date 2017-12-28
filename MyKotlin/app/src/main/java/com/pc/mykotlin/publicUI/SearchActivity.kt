package com.pc.mykotlin.publicUI

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.pc.mykotlin.R
import com.pc.mykotlin.searchShow.ShowSearchActivity
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        //点击返回
        search_iv_back.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                finish()
            }

        })


        //点击搜索输入的内容
        search_search.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {

                //获得输入框的值
                val etValue = search_et.text.toString()
                //带值跳转
                var i: Intent = Intent(this@SearchActivity,ShowSearchActivity::class.java)
                i.putExtra("etValue",etValue)
                startActivity(i)
                //销毁界面
                finish()

            }

        })

    }
}
