package com.pc.mykotlin.publicUI.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pc.mykotlin.JiaoZi.JiaoZiActivity
import com.pc.mykotlin.R
import com.pc.mykotlin.publicUI.SearchActivity
import com.pc.mykotlin.publicUI.sqc_sy.adapter.ShowYeAdapter
import com.pc.mykotlin.publicUI.sqc_sy.bean.ShouyeBean
import com.pc.mykotlin.publicUI.sqc_sy.presenter.ShowYePresenter
import com.pc.mykotlin.publicUI.sqc_sy.view.ShowYeView
import kotlinx.android.synthetic.main.frag_sy.*

/**
 * Created by pc on 2017/12/27.
 */

class Fragment_SY : Fragment(), ShowYeView {

    var showYePresenter: ShowYePresenter? = null
    var inient = Intent();

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        showYePresenter = ShowYePresenter(this)
        showYePresenter!!.relevance()



        return inflater!!.inflate(R.layout.frag_sy, container, false)


    }

    override fun showData(shouyeBean: ShouyeBean) {

        val showYeAdapter = ShowYeAdapter(activity, shouyeBean)
        sy_rec.layoutManager = LinearLayoutManager(activity)
        sy_rec.adapter = showYeAdapter

        showYeAdapter.setOnItemClickListener(object : ShowYeAdapter.OnItemClickListener {
            override fun onItemClik(position: Int, category: String) {

                inient.setClass(activity, JiaoZiActivity::class.java)
                inient.putExtra("position", position.toString())
                inient.putExtra("category", category)
                startActivity(inient)

            }
        })



        //点击跳转到搜索界面
        sy_search.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var i:Intent = Intent(activity, SearchActivity::class.java)
                startActivity(i)
            }

        })



        sy_rec.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                var layoutManager: LinearLayoutManager = recyclerView?.layoutManager as LinearLayoutManager
                var lastPositon = layoutManager.findLastVisibleItemPosition()
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastPositon == shouyeBean.issueList?.get(0)?.itemList!!.size - 1) {

                }
            }
        })


    }
}
