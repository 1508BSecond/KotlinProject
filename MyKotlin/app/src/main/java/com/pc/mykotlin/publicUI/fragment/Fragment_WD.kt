package com.pc.mykotlin.publicUI.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pc.mykotlin.R

/**
 * Created by pc on 2017/12/27.
 */

class Fragment_WD : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.frag_wd, container, false)
    }
}
