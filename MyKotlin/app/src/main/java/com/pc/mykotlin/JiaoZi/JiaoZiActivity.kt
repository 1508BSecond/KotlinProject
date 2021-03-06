package com.pc.mykotlin.JiaoZi

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import cn.jzvd.JZVideoPlayerStandard
import com.bumptech.glide.Glide
import com.jaeger.library.StatusBarUtil
import com.pc.mykotlin.JiaoZi.cache.CacheBean
import com.pc.mykotlin.JiaoZi.cache.DownLoadFile
import com.pc.mykotlin.JiaoZi.utils.JiaoPresenter
import com.pc.mykotlin.JiaoZi.utils.JiaoView
import com.pc.mykotlin.JiaoZi.utils.JiaoziBean
import com.pc.mykotlin.R
import kotlinx.android.synthetic.main.activity_jiao_zi.*

class JiaoZiActivity : AppCompatActivity(), JiaoView {

    var downLoadFile:DownLoadFile? = null

    var position: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jiao_zi)

        StatusBarUtil.setTranslucent(this)

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
        val blurred = DataBean!!.cover!!.blurred
        val feed = DataBean!!.cover!!.feed


        //设置值
        jiao_tv_name.setText(title)
        jiao_tv_lei.setText(category)
        jiao_tv_nei.setText(description)
        tv1.setText(""+duration)
        tv2.setText(""+duration)
        tv3.setText(""+duration)

        Glide.with(this@JiaoZiActivity).load(blurred).into(img)

        tv_huan.setOnClickListener(View.OnClickListener {

            var cache:CacheBean = CacheBean(DataBean!!.title!!, DataBean!!.cover!!.feed!!)

            //进行下载
            downLoadFile = DownLoadFile(this@JiaoZiActivity,DataBean?.playUrl, "/"+DataBean!!.title!!+".mp4"+Environment.getExternalStorageDirectory(),3)
            downLoadFile?.downLoad()

            Toast.makeText(this@JiaoZiActivity,"开始下载",Toast.LENGTH_SHORT).show()

        })

        fanhui.setOnClickListener(View.OnClickListener {
            finish()
        })

        videoplayer.setUp(url, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");
        videoplayer.thumbImageView.setImageURI(Uri.parse(feed));
    }

    override fun onBackPressed() {
        if (videoplayer.isPressed){
            return
        }
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        videoplayer.release()
    }

}


