package com.pc.mykotlin.JiaoZi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import cn.jzvd.JZVideoPlayerStandard
import com.pc.mykotlin.JiaoZi.utils.JiaoPresenter
import com.pc.mykotlin.JiaoZi.utils.JiaoView
import com.pc.mykotlin.JiaoZi.utils.JiaoziBean
import com.pc.mykotlin.R
import kotlinx.android.synthetic.main.activity_jiao_zi.*

class JiaoZiActivity : AppCompatActivity(), JiaoView {

    var position: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jiao_zi)

        val category = intent.getStringExtra("category")
        val stringExtra = intent.getStringExtra("position")
        position= Integer.valueOf(stringExtra)


        var p: JiaoPresenter = JiaoPresenter(this)
        p.getpresenter(category)


    }

    override fun geiview(jiaoziBean: JiaoziBean) {

      //获得视频详情的数据
        val DataBean = jiaoziBean.itemList!!.get(position!!).data
        //得到标题,内容和类型,以及视频
        val title = DataBean!!.title
        val description = DataBean!!.description
        val category = DataBean!!.category
        val url = DataBean!!.playUrl
        val duration = DataBean!!.duration

        //设置值
        jiao_tv_name.setText(title)
        jiao_tv_lei.setText(category)
        jiao_tv_nei.setText(description)
        tv1.setText(""+duration)
        tv2.setText(""+duration)
        tv3.setText(""+duration)

        tv_huan.setOnClickListener(View.OnClickListener {
            Toast.makeText(this@JiaoZiActivity,"缓存正在改进",Toast.LENGTH_SHORT).show()
        })

        videoplayer.setUp(url, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");
    }
    

}


