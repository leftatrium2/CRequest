package com.ellaclub.crequestdemo.retrofit2.my_test.client

import com.ellaclub.crequestdemo.retrofit2.my_test.api.MyTest

object MyTestClient {
    val feedApi: MyTest by lazy {
        RetrofitClient.client.build().create(MyTest::class.java)
    }
}