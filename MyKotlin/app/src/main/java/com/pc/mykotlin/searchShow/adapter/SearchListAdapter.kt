package com.pc.mykotlin.searchShow.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.pc.mykotlin.R
import com.pc.mykotlin.searchShow.bean.SearchBean

/**
 * Created by pc on 2017/12/28.
 */
class SearchListAdapter(context:Context,list: List<SearchBean.ItemListBean>): RecyclerView.Adapter<SearchListAdapter.MyViewHolder>() {

    private var context:Context = context
    private var list:List<SearchBean.ItemListBean> = list

    //声明接口
    var listener:OnItemSearchListener? = null
    interface OnItemSearchListener{
        fun OnItemSearchClick(position: Int)
    }
    fun setOnItemSearchListener(listener: OnItemSearchListener){
        this.listener = listener
    }


    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        //设置图片
        Glide.with(context).load(list.get(position)?.data?.cover?.feed).into(holder?.iv)
        //文字
        holder?.tv_top?.text = list.get(position)?.data?.title
        holder?.tv_bottom?.text = list.get(position)?.data?.category

        //点击跳转播放
        holder?.ll?.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                listener?.OnItemSearchClick(position)
            }

        })
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.search_list_item,parent,false))
    }


    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var iv:ImageView = itemView?.findViewById(R.id.search_list_iv) as ImageView
        var tv_top:TextView = itemView?.findViewById(R.id.search_list_tv_top) as TextView
        var tv_bottom:TextView = itemView?.findViewById(R.id.search_list_tv_bottom) as TextView
        var ll:LinearLayout = itemView?.findViewById(R.id.search_list_ll) as LinearLayout

    }
}