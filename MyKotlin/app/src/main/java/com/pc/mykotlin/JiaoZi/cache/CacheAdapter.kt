package com.pc.mykotlin.JiaoZi.cache

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.pc.mykotlin.R

/**
 * Created by pc on 2017/12/29.
 */
class CacheAdapter(context: Context,list:List<CacheBean>): RecyclerView.Adapter<CacheAdapter.MyViewHolder>() {

    private var context:Context = context
    private var list:List<CacheBean> = list

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {

        //设置图片
        Glide.with(context).load(list.get(position).img)
        holder?.tv_title?.text = list.get(position).titleValue

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cache_rlv_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }


    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var iv: ImageView = itemView?.findViewById(R.id.cache_rlv_iv) as ImageView
        var tv_title:TextView = itemView?.findViewById(R.id.cache_tv_title) as TextView
    }
}