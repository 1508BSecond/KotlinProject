package com.pc.mykotlin.publicUI.hot.net

import com.pc.mykotlin.publicUI.hot.bean.HotBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Helloworld on 2017/12/28.
 */
interface ApiService {
//http://baobab.wandoujia.com/api/v3/ranklist?num=10&strategy=%s&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    @GET("v3/ranklist")
    fun getHotData(@Query("num") num :Int, @Query("strategy") strategy :String,
                   @Query("udid") udid :String, @Query("vc") vc :Int) :Flowable<HotBean>

}