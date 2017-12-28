package com.pc.mykotlin.publicUI.sqc_sy.adapter

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
import com.pc.mykotlin.publicUI.sqc_sy.bean.ShouyeBean

/**
 * Created by TR on 2017/12/27.
 */
class ShowYeAdapter(mContext: Context, shouYeBean2: ShouyeBean) : RecyclerView.Adapter<ShowYeAdapter.MyHolder>() {

    var mContext: Context = mContext
    var shouYeBean2: ShouyeBean = shouYeBean2
    var itemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClik(position: Int, category: String)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }


    var inflater: LayoutInflater? = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(mContext).inflate(R.layout.syitem, parent, false))
    }

    override fun onBindViewHolder(holder: MyHolder?, position: Int) {

        if (position == 0) {

        } else {
            val bean = shouYeBean2.issueList?.get(0)?.itemList!!.get(position)
            Glide.with(mContext).load(bean.data?.cover?.detail).into(holder?.bigImage as ImageView)
            Glide.with(mContext).load(bean.data?.cover?.blurred).into(holder?.img as ImageView)


            holder.text1.text = bean.data?.title
            holder.text2.text = bean.data?.slogan
            holder.linearLayout?.setOnClickListener() {
                itemClickListener?.onItemClik(position, bean.data?.category as String)
            }
        }


    }


    override fun getItemCount(): Int {


        return shouYeBean2.issueList?.get(0)?.itemList!!.size
    }

    class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView = itemView!!.findViewById(R.id.image) as ImageView
        var bigImage: ImageView = itemView!!.findViewById(R.id.bigImage) as ImageView

        var text1: TextView = itemView!!.findViewById(R.id.tetiao) as TextView
        var text2: TextView = itemView!!.findViewById(R.id.fabu) as TextView
        var linearLayout: LinearLayout = itemView!!.findViewById(R.id.sy_linearLayout) as LinearLayout

    }


}