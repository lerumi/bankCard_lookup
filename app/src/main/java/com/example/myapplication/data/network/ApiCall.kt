package com.example.myapplication.data.network

import com.example.myapplication.data.model.Bank
import com.example.myapplication.data.model.Card
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCall {
    @GET("{cardNumber}")
    suspend fun getCardByNumber(@Path("cardNumber") cardNumber: String): Card
}
