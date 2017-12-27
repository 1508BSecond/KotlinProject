package com.pc.mykotlin.powerFX.model

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.pc.mykotlin.powerFX.bean.FindBean
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
class FindModel {
    fun getFindData():Flowable<List<FindBean>>{

        var i = HttpLoggingInterceptor()
        i.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okhttp = OkHttpClient.Builder()
                .addInterceptor(i)
                .build()
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(API.URL)
                .client(okhttp)
                .build()
        val apiService = retrofit.create(ApiService::class.java)
        val flowable = apiService.findData()

        return flowable
    }
}