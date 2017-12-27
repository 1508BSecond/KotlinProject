package com.pc.mykotlin.powerFX.presenter

import com.pc.mykotlin.powerFX.bean.FindBean
import com.pc.mykotlin.powerFX.model.FindModel
import com.pc.mykotlin.powerFX.view.FindView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by pc on 2017/12/27.
 */
class FindPresenter(findView: FindView) {

    var view:FindView = findView

    var model:FindModel = FindModel()

    fun pm(){
        val flowable = model.getFindData()
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<List<FindBean>>() {
                    override fun onComplete() {
                    }

                    override fun onNext(t: List<FindBean>?) {
                        view!!.findShow(t!!)
                    }

                    override fun onError(t: Throwable?) {
                    }

                })
    }

}