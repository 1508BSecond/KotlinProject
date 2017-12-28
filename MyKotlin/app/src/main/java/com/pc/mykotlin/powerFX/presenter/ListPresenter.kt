package com.pc.mykotlin.powerFX.presenter

import com.pc.mykotlin.powerFX.bean.ListBean
import com.pc.mykotlin.powerFX.model.ListModel
import com.pc.mykotlin.powerFX.view.ListInfoView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by pc on 2017/12/27.
 */
class ListPresenter(listInfoView: ListInfoView) {

    val view: ListInfoView = listInfoView

    var model: ListModel = ListModel()

    fun pm(categoryName: String, udid: String, vc: Int) {
        val flowable = model.getListData(categoryName, udid, vc)
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<ListBean>() {
                    override fun onNext(t: ListBean?) {
                        view!!.listShow(t!!)
                    }

                    override fun onError(t: Throwable?) {
                    }

                    override fun onComplete() {
                    }

                })
    }

}