package com.pc.mykotlin.searchShow

import com.pc.mykotlin.searchShow.bean.SearchBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by pc on 2017/12/28.
 */
interface ApiService {
    /**
     * http://baobab.kaiyanapp.com/api/v1/
     * search?num=10&query=%E4%BD%A0&start=10
     *
     */
    @GET("search")
    fun search(@Query("num")num:Int,
               @Query("query")query:String,
               @Query("start")start:Int):Flowable<SearchBean>
}