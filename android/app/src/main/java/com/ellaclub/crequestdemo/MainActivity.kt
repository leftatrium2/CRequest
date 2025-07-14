package com.ellaclub.crequestdemo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ellaclub.crequestdemo.bean.my_test.parse.BaseModel
import com.ellaclub.crequestdemo.bean.my_test.parse.ImageModel
import com.ellaclub.crequestdemo.bean.my_test.parse.LinkModel
import com.ellaclub.crequestdemo.bean.my_test.parse.ParseModel
import com.ellaclub.crequestdemo.bean.my_test.parse.TextModel
import com.ellaclub.crequestdemo.gson.GsonUtils
import com.ellaclub.crequestdemo.retrofit2.my_test.client.MyTestClient
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main_activity)
        findViewById<Button>(R.id.btn_go_to_gson).setOnClickListener {
            val parseModel = GsonUtils.convert3()
            for (model: BaseModel in parseModel.data!!) {
                if (model.type.equals("text")) {
                    Log.d(TAG, (model as TextModel).text)
                } else if (model.type.equals("image")) {
                    Log.d(TAG, "image: " + (model as ImageModel).desc)
                } else if (model.type.equals("link")) {
                    Log.d(TAG, "link: " + (model as LinkModel).comment)
                }
            }
        }
        findViewById<Button>(R.id.btn_go_to_my_test).setOnClickListener {
            MyTestClient.feedApi.getFeeds(0)
                .enqueue(object : retrofit2.Callback<ParseModel<BaseModel>> {
                    override fun onResponse(
                        call: Call<ParseModel<BaseModel>>, response: Response<ParseModel<BaseModel>>
                    ) {
                        val parseModel = response.body()
                        for (model: BaseModel in parseModel!!.data!!) {
                            if (model.type.equals("text")) {
                                Log.d(TAG, (model as TextModel).text)
                            } else if (model.type.equals("image")) {
                                Log.d(TAG, "image: " + (model as ImageModel).desc)
                            } else if (model.type.equals("link")) {
                                Log.d(TAG, "link: " + (model as LinkModel).comment)
                            }
                        }
                    }

                    override fun onFailure(call: Call<ParseModel<BaseModel>>, t: Throwable) {
                        Log.e(TAG, t.message.toString())
                    }

                })
        }
    }
}