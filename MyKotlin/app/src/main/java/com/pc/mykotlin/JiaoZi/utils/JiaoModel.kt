package com.pc.mykotlin.JiaoZi.utils

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Flowable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by wangziying on 2017/12/27.
 */
class JiaoModel {

    fun getmodel(categoryName:String,udid:String,vc:Int):Flowable<JiaoziBean>{

        val retrofit = Retrofit.Builder().baseUrl(ApiJiao.Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()


        val jApiServer = retrofit.create(JApiServer::class.java)

        val flowable = jApiServer.getvideo(categoryName, "26868b32e808498db32fd51fb422d00175e179df", 83)

        return flowable
    }


}