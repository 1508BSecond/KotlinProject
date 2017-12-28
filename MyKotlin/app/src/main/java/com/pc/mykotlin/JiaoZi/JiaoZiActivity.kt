package com.pc.mykotlin.JiaoZi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cn.jzvd.JZVideoPlayerStandard
import com.pc.mykotlin.JiaoZi.utils.JiaoPresenter
import com.pc.mykotlin.JiaoZi.utils.JiaoView
import com.pc.mykotlin.JiaoZi.utils.JiaoziBean
import com.pc.mykotlin.R
import kotlinx.android.synthetic.main.activity_jiao_zi.*

class JiaoZiActivity : AppCompatActivity() ,JiaoView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jiao_zi)

        var p:JiaoPresenter = JiaoPresenter(this)
        p.getpresenter("时尚")


    }
    override fun geiview(jiaoziBean: JiaoziBean) {


        val DataBean = jiaoziBean.itemList!!.get(0).data
        val url = DataBean!!.playInfo!!.get(0).url

        videoplayer.setUp(url, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL,"");
    }

}
