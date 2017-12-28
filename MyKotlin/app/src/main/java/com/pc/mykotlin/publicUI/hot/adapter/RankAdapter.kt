package com.bwie.adapter

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
import com.pc.mykotlin.publicUI.hot.bean.HotBean


class RankAdapter(context:Context, list: ArrayList<HotBean.ItemListBean>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var mcontext:Context = context
    var mlist: ArrayList<HotBean.ItemListBean> = list

    interface OnItemClickLitener{
        fun onItemClick(list: HotBean.ItemListBean.DataBean?,position: Int)
    }
    var litener:OnItemClickLitener? = null
    fun setOnItemClickListener(litener:OnItemClickLitener){
        this.litener = litener
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var viewholder:MyViewHolder = holder as MyViewHolder

        viewholder.tv_title.setText(mlist.get(position).data!!.title)
        //viewholder.tv_blow.setText(mlist.get(position).data!!.category+"/")
        //viewholder.iv_photo.setImageURI(Uri.parse(mlist.get(position).data!!.cover!!.detail))

        Glide.with(mcontext)
                .load(mlist.get(position).data!!.cover!!.detail)
                .crossFade()
                .into(viewholder.iv_photo);
        viewholder.ll_moban.setOnClickListener{
            litener?.onItemClick(mlist.get(position).data,position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.item_rank,parent,false))
    }

    override fun getItemCount(): Int {
        return mlist.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var iv_photo : ImageView = itemView.findViewById(R.id.iv_photo)
        var tv_title : TextView = itemView.findViewById(R.id.tv_title)
        var ll_moban : LinearLayout = itemView.findViewById(R.id.ll_moban)
    }
}