package com.pc.mykotlin.publicUI.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.pc.mykotlin.R
import com.pc.mykotlin.publicUI.SearchActivity
import com.pc.mykotlin.publicUI.hot.BaseFragment
import com.pc.mykotlin.publicUI.hot.RankFragment
import com.pc.mykotlin.publicUI.hot.adapter.HotAdatpter
import kotlinx.android.synthetic.main.frag_rm.*

/**
 * Created by pc on 2017/12/27.
 */

class Fragment_RM : BaseFragment() {


    var mTabs = listOf<String>("周排行", "月排行", "总排行").toMutableList()
    lateinit var mFragments: ArrayList<Fragment>
    val STRATEGY = arrayOf("weekly", "monthly", "historical")
    override fun getLayoutResources(): Int {
        return R.layout.frag_rm
    }

    override fun initView() {
        var weekFragment: RankFragment = RankFragment()
        var weekBundle = Bundle()
        weekBundle.putString("strategy", STRATEGY[0])
        weekFragment.arguments = weekBundle
        var monthFragment: RankFragment = RankFragment()
        var monthBundle = Bundle()
        monthBundle.putString("strategy", STRATEGY[1])
        monthFragment.arguments = monthBundle
        var allFragment: RankFragment = RankFragment()
        var allBundle = Bundle()
        allBundle.putString("strategy", STRATEGY[2])
        allFragment.arguments = allBundle
        mFragments = ArrayList()
        mFragments.add(weekFragment as Fragment)
        mFragments.add(monthFragment as Fragment)
        mFragments.add(allFragment as Fragment)
        vp_content.adapter = HotAdatpter(fragmentManager, mFragments, mTabs)
        tabs.setupWithViewPager(vp_content)

        rm_search.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var i: Intent = Intent(activity, SearchActivity::class.java)
                startActivity(i)
            }

        })

    }



}
