package com.ellaclub.crequestdemo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ellaclub.crequest.CRequestManager
import com.ellaclub.crequestdemo.gson.GsonUtils

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main_activity)
        findViewById<Button>(R.id.btn_go_to_gson).setOnClickListener {
            val data2 = GsonUtils.convert2()
            for (item in data2.data?.datas!!) {
                Log.d(TAG, item.title + " " + item.desc + " " + item.link)
            }
        }
    }
}