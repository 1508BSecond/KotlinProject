package com.pc.mykotlin.searchShow.model

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.pc.mykotlin.searchShow.API
import com.pc.mykotlin.searchShow.ApiService
import com.pc.mykotlin.searchShow.bean.SearchBean
import io.reactivex.Flowable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by pc on 2017/12/28.
 */
class SearchModel {

    fun getSearchData(num:Int,query:String,start:Int):Flowable<SearchBean>{

        var i:HttpLoggingInterceptor = HttpLoggingInterceptor()
        i.setLevel(HttpLoggingInterceptor.Level.BODY)

        var okhttp = OkHttpClient.Builder()
                .addInterceptor(i)
                .build()

        var retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API.URL)
                .client(okhttp)
                .build()
        val apiService = retrofit.create(ApiService::class.java)
        val flowable = apiService.search(num, query, start)


        return flowable
    }

}