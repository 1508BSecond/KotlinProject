package com.pc.mykotlin.publicUI.hot.Model

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.pc.mykotlin.publicUI.hot.bean.HotBean
import com.pc.mykotlin.publicUI.hot.net.Api
import com.pc.mykotlin.publicUI.hot.net.ApiService
import io.reactivex.Flowable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Helloworld on 2017/12/27.
 */
class HotModel {

    fun getDate(strategy: String?):Flowable<HotBean>{
        val retrofit = Retrofit.Builder().baseUrl(Api.HOT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        val apiService = retrofit.create(ApiService::class.java)
        val flowable = apiService.getHotData(10, strategy!!, "26868b32e808498db32fd51fb422d00175e179df", 83)

        return flowable

    }

}