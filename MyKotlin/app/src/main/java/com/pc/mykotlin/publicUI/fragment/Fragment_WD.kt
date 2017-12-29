package com.pc.mykotlin.publicUI.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.pc.mykotlin.JiaoZi.cache.CacheListActivity
import com.pc.mykotlin.R

/**
 * Created by pc on 2017/12/27.
 */

class Fragment_WD : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.frag_wd, container, false)
        var frag_wd_cache = view.findViewById<TextView>(R.id.frag_wd_cache) as TextView
        frag_wd_cache.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                val i: Intent = Intent(activity, CacheListActivity::class.java)
                startActivity(i)
            }
        })

        return view
    }
}
