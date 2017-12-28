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
import com.pc.mykotlin.powerFX.bean.FindBean

/**
 * Created by pc on 2017/12/27.
 */
class MyFxAdapter(context: Context,list: List<FindBean>): RecyclerView.Adapter<MyFxAdapter.MyViewHolder>() {

    private var context:Context = context
    private var list:List<FindBean> = list

    //设置接口回调
    var listener:OnItemListener? = null
    interface OnItemListener{
        fun OnItemClick(findBean: FindBean)
    }
    fun setOnItemListener(listener:OnItemListener){
        this.listener = listener
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        //设置图片
        Glide.with(context).load(list.get(position).bgPicture).into(holder?.iv!!)
        //文字
        holder?.tv?.text = list.get(position).name

        //点及跳转到展示界面
        holder?.rl?.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                listener?.OnItemClick(list.get(position))
            }

        })
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.fx_rlv_item,parent,false))
    }


    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var iv:ImageView = itemView?.findViewById(R.id.fx_rlv_iv) as ImageView
        var tv:TextView = itemView?.findViewById(R.id.fx_rlv_tv) as TextView
        var rl:RelativeLayout = itemView?.findViewById(R.id.fx_rl) as RelativeLayout
    }
}