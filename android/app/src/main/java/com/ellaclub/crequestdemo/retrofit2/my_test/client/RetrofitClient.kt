package com.ellaclub.crequestdemo.retrofit2.my_test.client

import com.ellaclub.crequestdemo.bean.my_test.parse.BaseModel
import com.ellaclub.crequestdemo.gson.BaseModelAdapter
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {
    val client: Retrofit.Builder by lazy {
        val gson = GsonBuilder()
            .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
            .registerTypeAdapter(BaseModel::class.java, BaseModelAdapter())
            .create()
        val okHttpClient = OkHttpClient
            .Builder()
            .readTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .connectTimeout(5, TimeUnit.SECONDS)
            .build()
        Retrofit
            .Builder()
            .baseUrl("http://10.222.100.110:9001/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }
}