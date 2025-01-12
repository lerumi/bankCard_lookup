package com.example.myapplication.data.network

import com.example.myapplication.data.model.Card

suspend fun GetBankCardInfoByApi(text: String): Card {
    try {
        val bankCard = GetBankCardInfo().getCardByNumber(text)
        return bankCard
    } catch (e: Exception) {
        println("Error: ${e}")
        return Card()
    }
}