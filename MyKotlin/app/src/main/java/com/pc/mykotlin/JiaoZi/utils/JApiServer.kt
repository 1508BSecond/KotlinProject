package com.pc.mykotlin.JiaoZi.utils

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by wangziying on 2017/12/27.
 */
interface JApiServer {

    //http://baobab.kaiyanapp.com/api/v3/videos?categoryName=%E6%97%B6%E5%B0%9A&strategy=date&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    //播放视频的接口
    @GET("v3/videos")
    fun getvideo(@Query("categoryName") categoryName:String,
                 @Query("udid") udid:String,
                 @Query("vc") vc:Int
                 ):Flowable<JiaoziBean>


}