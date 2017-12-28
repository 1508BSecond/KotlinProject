package com.pc.mykotlin.publicUI.sqc_sy.presenter

import android.util.Log
import com.pc.mykotlin.publicUI.sqc_sy.bean.ShouYeBean2
import com.pc.mykotlin.publicUI.sqc_sy.bean.ShouyeBean
import com.pc.mykotlin.publicUI.sqc_sy.model.ShowYeModel
import com.pc.mykotlin.publicUI.sqc_sy.view.ShowYeView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by TR on 2017/12/27.
 */
class ShowYePresenter(showYeView: ShowYeView) {

    var model: ShowYeModel? = ShowYeModel()
    var showYeView: ShowYeView? = showYeView


    fun relevance() {

        val data = model!!.getData()

        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<ShouyeBean>() {
                    override fun onNext(t: ShouyeBean?) {
                        showYeView?.showData(t!!)
                    }

                    override fun onError(t: Throwable?) {
                        Log.i("xxx",t!!.message)
                    }

                    override fun onComplete() {
                    }

                })


    }
}