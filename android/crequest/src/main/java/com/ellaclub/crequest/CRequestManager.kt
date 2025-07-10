package com.ellaclub.crequest

import android.annotation.SuppressLint
import android.content.Context

@SuppressLint("StaticFieldLeak")
object CRequestManager {
    private lateinit var context: Context
    fun init(context: Context) {
        this.context = context.applicationContext
    }
}