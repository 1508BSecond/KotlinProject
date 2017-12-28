package com.pc.mykotlin.searchShow.presenter

import com.pc.mykotlin.searchShow.bean.SearchBean
import com.pc.mykotlin.searchShow.model.SearchModel
import com.pc.mykotlin.searchShow.view.SearchShowView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by pc on 2017/12/28.
 */
class SearchPresenter(searchView: SearchShowView) {

    var view: SearchShowView = searchView

    var model:SearchModel = SearchModel()

    fun pm(num:Int,query:String,start:Int){
        val flowable = model.getSearchData(num, query, start)
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :DisposableSubscriber<SearchBean>(){
                    override fun onError(t: Throwable?) {
                    }

                    override fun onNext(t: SearchBean?) {
                        view?.searchShow(t!!)
                    }

                    override fun onComplete() {
                    }

                })
    }

}