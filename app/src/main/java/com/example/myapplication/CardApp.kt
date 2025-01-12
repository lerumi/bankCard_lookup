package com.example.myapplication

import android.app.Application
import com.example.myapplication.app_context_holder.AppContextHolder
import com.example.myapplication.data.database.QueryDb
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CardApp : Application() {
    lateinit var queryDatabase: QueryDb
    override fun onCreate() {
        super.onCreate()
        queryDatabase = QueryDb.createDataBase(applicationContext)
        AppContextHolder.setContext(this)
    }
}