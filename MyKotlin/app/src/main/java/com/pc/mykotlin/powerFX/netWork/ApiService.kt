package com.pc.mykotlin.powerFX.netWork

import com.pc.mykotlin.powerFX.bean.FindBean
import com.pc.mykotlin.powerFX.bean.ListBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

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

    /**
     * http://baobab.kaiyanapp.com/api/v3/
     * videos?categoryName=%E6%97%B6%E5%B0%9A&strategy=%s&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
     * http://baobab.kaiyanapp.com/api/v3/
     * videos?categoryName=%E6%97%B6%E5%B0%9A&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
     */
    @GET("videos")
    fun listData(@Query("categoryName")categoryName:String,
                 @Query("udid")udid:String,
                 @Query("vc")vc:Int):Flowable<ListBean>

}