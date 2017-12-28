package com.pc.mykotlin.JiaoZi.utils

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by wangziying on 2017/12/27.
 */
class JiaoPresenter(view: JiaoView) {

    val model:JiaoModel?= JiaoModel()
    val view:JiaoView?=view

    fun getpresenter(categoryName:String){

        val flowable = model!!.getmodel(categoryName, "26868b32e808498db32fd51fb422d00175e179df", 83)

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSubscriber<JiaoziBean>(){
                    override fun onNext(t: JiaoziBean?) {
                        view!!.geiview(t!!)
                    }

                    override fun onComplete() {

                    }

                    override fun onError(t: Throwable?) {

                    }

                })
    }
}