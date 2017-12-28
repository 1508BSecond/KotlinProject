package com.pc.mykotlin.publicUI.hot.Presenter

import com.pc.mykotlin.publicUI.hot.Model.HotModel
import com.pc.mykotlin.publicUI.hot.View.HotView
import com.pc.mykotlin.publicUI.hot.bean.HotBean
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by Helloworld on 2017/12/27.
 */
class HotPresenter(hotView:HotView){

    val hotModel:HotModel?= HotModel()
    val hotView:HotView?=hotView

    fun pm(strategy:String){
        var strategy: String = strategy
        val flowable = hotModel!!.getDate(strategy)

        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSubscriber<HotBean>(){
                    override fun onComplete() {
                    }

                    override fun onError(t: Throwable?) {
                    }

                    override fun onNext(t: HotBean?) {
                        hotView!!.hView(t!!)
                    }

                })

    }

}