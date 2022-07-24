package com.example.app_cl3_t5wn_valladaresbazalarpaoloneil.utils

import android.app.Application
import android.content.Context

class AppConfiguration: Application() {

    companion object{
        lateinit var CONTEXT:Context

    }

    override fun onCreate() {
        super.onCreate()
        //crear objeto CONTEXT
        CONTEXT =applicationContext

    }

}