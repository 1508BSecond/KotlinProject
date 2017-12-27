package com.pc.mykotlin.powerFX.netWork

import com.pc.mykotlin.powerFX.bean.FindBean
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * Created by pc on 2017/12/27.
 */
interface ApiService {

    /**
     * http://baobab.wandoujia.com/api/v2/
     * feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
     * 发现
     */
    @GET("categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun findData():Flowable<List<FindBean>>
}