package com.pc.mykotlin.publicUI

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.hjm.bottomtabbar.BottomTabBar
import com.jaeger.library.StatusBarUtil
import com.pc.mykotlin.R
import com.pc.mykotlin.publicUI.fragment.Fragment_FX
import com.pc.mykotlin.publicUI.fragment.Fragment_RM
import com.pc.mykotlin.publicUI.fragment.Fragment_SY
import com.pc.mykotlin.publicUI.fragment.Fragment_WD

class MainActivity : AppCompatActivity() {

    private var mMainBar: BottomTabBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StatusBarUtil.setTransparent(this)

        initView()

        /*if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();*/

        //加载四个Fragment
        mMainBar!!.init(supportFragmentManager)
                .setImgSize(50f, 50f)
                .setFontSize(12f)
                .setTabPadding(4f, 6f, 10f)
                .setChangeColor(Color.BLACK, Color.DKGRAY)
                .addTabItem("首页", R.mipmap.home_normal, Fragment_SY::class.java)
                .addTabItem("发现", R.mipmap.find_normal, Fragment_FX::class.java)
                .addTabItem("热门", R.mipmap.hot_normal, Fragment_RM::class.java)
                .addTabItem("我的", R.mipmap.mine_normal, Fragment_WD::class.java)
                .isShowDivider(false)
                .setOnTabChangeListener { position, name -> }

    }

    private fun initView() {
        mMainBar = findViewById(R.id.main_bar) as BottomTabBar
    }
}
