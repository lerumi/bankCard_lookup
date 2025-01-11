package com.example.myapplication.data.network

import com.example.myapplication.data.model.Card

suspend fun GetBankCardInfoByApi(text: String): Card {
    try {
        val bankCard = GetBankCardInfo().getCardByNumber(text)
        println("latasa ${bankCard}")
        return bankCard
    } catch (e: Exception) {
        println("latasa Error: Василий, ну чтож за говнокод?( ${e}")
        return Card()
    }
}