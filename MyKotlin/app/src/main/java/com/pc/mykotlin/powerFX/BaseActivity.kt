package com.pc.mykotlin.powerFX

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<T> : AppCompatActivity() {

    var presenter: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())

        initView()
        initData()
        presenter = getPresenter()

    }

    internal abstract fun getPresenter(): T?

    abstract fun initData()

    abstract fun initView()

    abstract fun layoutId(): Int
}
