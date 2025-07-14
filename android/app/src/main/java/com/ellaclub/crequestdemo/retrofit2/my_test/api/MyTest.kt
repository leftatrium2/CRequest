package com.ellaclub.crequestdemo.retrofit2.my_test.api

import com.ellaclub.crequestdemo.bean.my_test.parse.BaseModel
import com.ellaclub.crequestdemo.bean.my_test.parse.ParseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyTest {
    @GET("parse_api")
    fun getFeeds(@Query("page") page: Int): Call<ParseModel<BaseModel>>
}

