package com.pc.mykotlin.publicUI.hot

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.bwie.adapter.RankAdapter
import com.pc.mykotlin.JiaoZi.JiaoZiActivity
import com.pc.mykotlin.R
import com.pc.mykotlin.publicUI.hot.Presenter.HotPresenter
import com.pc.mykotlin.publicUI.hot.View.HotView
import com.pc.mykotlin.publicUI.hot.bean.HotBean
import kotlinx.android.synthetic.main.rank_fragment.*

/**
 * Created by Helloworld on 2017/12/28.
 */
class RankFragment:BaseFragment(),HotView {


    lateinit var mPresenter: HotPresenter
    lateinit var mStrategy: String
    lateinit var mAdapter: RankAdapter
    var mList: ArrayList<HotBean.ItemListBean> = ArrayList()

    override fun getLayoutResources(): Int {
        return R.layout.rank_fragment
    }

    override fun initView() {

        recyclerView.layoutManager = LinearLayoutManager(context)

        mAdapter = RankAdapter(context, mList)
        recyclerView.adapter = mAdapter
        if (arguments != null) {
            mStrategy = arguments.getString("strategy")
            mPresenter = HotPresenter(this)
            mPresenter.pm(mStrategy)
        }

    }

    override fun hView(hotBean: HotBean) {

        if(mList.size>0){
            mList.clear()
        }
        hotBean.itemList?.forEach {
            it.data?.let { it1 -> mList.add(it) }
        }
        mAdapter.notifyDataSetChanged()

        mAdapter.setOnItemClickListener(object : RankAdapter.OnItemClickLitener{
            override fun onItemClick(list: HotBean.ItemListBean.DataBean?, position: Int) {

                val category = list?.category

                var i: Intent = Intent(activity,JiaoZiActivity::class.java)
                i.putExtra("category",category)
                i.putExtra("position",""+position)
                startActivity(i)

            }


        })

    }

}