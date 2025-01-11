package com.example.myapplication.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun GetBankCardInfo():ApiCall{
    val retrofit = Retrofit.Builder()
        .baseUrl("https://lookup.binlist.net/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val api = retrofit.create(ApiCall::class.java)
    return api
}