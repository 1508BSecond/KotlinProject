package com.pc.mykotlin.powerFX.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.pc.mykotlin.R
import com.pc.mykotlin.powerFX.bean.ListBean

/**
 * Created by pc on 2017/12/27.
 */
class ListRlvAdapter(context: Context,list: List<ListBean.ItemListBean>): RecyclerView.Adapter<ListRlvAdapter.MyViewHolder>() {
    private var context:Context = context
    private var list:List<ListBean.ItemListBean> = list

    //接口回调
    var listListener:OnItemListListener? = null
    interface OnItemListListener{
        fun OnItemListClick(position: Int)
    }
    fun setOnItemListListener(listListener:OnItemListListener){
        this.listListener = listListener
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {

        //设置图片
        Glide.with(context).load(list.get(position).data?.cover?.feed).into(holder?.iv)
        holder?.tv?.text = list.get(position).data?.title

        //设置点击跳转
        holder?.rl?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                listListener?.OnItemListClick(position)
            }

        })

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_rlv_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }



    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var iv:ImageView = itemView?.findViewById(R.id.list_rlv_iv) as ImageView
        var tv:TextView = itemView?.findViewById(R.id.list_rlv_tv_title) as TextView
        var rl:RelativeLayout = itemView?.findViewById(R.id.list_rlv_rl) as RelativeLayout
    }
}