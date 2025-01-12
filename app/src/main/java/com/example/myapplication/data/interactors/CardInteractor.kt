package com.example.myapplication.data.interactors

import com.example.myapplication.data.database.CardEntity
import com.example.myapplication.data.model.Card

interface CardInteractor {
    suspend fun insertCard(card: Card, bin: String)
    suspend fun getAllCards(): List<Card>
}