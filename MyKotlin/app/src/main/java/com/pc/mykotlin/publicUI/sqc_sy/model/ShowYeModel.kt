package com.pc.mykotlin.publicUI.sqc_sy.model

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.pc.mykotlin.publicUI.sqc_sy.api.Api
import com.pc.mykotlin.publicUI.sqc_sy.bean.ShouYeBean2
import com.pc.mykotlin.publicUI.sqc_sy.bean.ShouyeBean
import com.pc.mykotlin.publicUI.sqc_sy.inter.ApiService
import io.reactivex.Flowable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by TR on 2017/12/27.
 */
class ShowYeModel {


    fun getData(): Flowable<ShouyeBean> {
        val retrofit = Retrofit.Builder()
                .baseUrl(Api.Shouye)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        val apiService = retrofit.create(ApiService::class.java)
        val shouYeData = apiService.getShouYeData(2, "26868b32e808498db32fd51fb422d00175e179df", 83)

        return shouYeData
    }

}