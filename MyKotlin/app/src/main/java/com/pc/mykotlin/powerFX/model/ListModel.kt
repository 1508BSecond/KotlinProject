package com.pc.mykotlin.powerFX.model

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.pc.mykotlin.powerFX.bean.ListBean
import com.pc.mykotlin.powerFX.netWork.API
import com.pc.mykotlin.powerFX.netWork.ApiService
import io.reactivex.Flowable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by pc on 2017/12/27.
 */
class ListModel {

    fun getListData(categoryName: String, udid: String, vc: Int): Flowable<ListBean> {

        var i: HttpLoggingInterceptor = HttpLoggingInterceptor()
        i.setLevel(HttpLoggingInterceptor.Level.BODY)

        var okhttp: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(i)
                .build()
        var retrofit: Retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API.URL2)
                .client(okhttp)
                .build()
        val apiService = retrofit.create(ApiService::class.java)
        val flowable = apiService.listData(categoryName, udid, vc)

        return flowable
    }

}