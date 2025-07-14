package com.ellaclub.crequestdemo

import android.app.Application
import com.ellaclub.crequest.CRequestManager

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        CRequestManager.init(this)
    }
}