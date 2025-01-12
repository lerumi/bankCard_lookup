package com.example.myapplication.data.interactors

import com.example.myapplication.data.database.CardEntity
import com.example.myapplication.data.database.QueryDb
import com.example.myapplication.data.mappers.toCard
import com.example.myapplication.data.mappers.toCardEntity
import com.example.myapplication.data.model.Card
import javax.inject.Inject

class CardInteractorImpl @Inject constructor(db: QueryDb) : CardInteractor {
    private val cardDao = db.CardDao()
    private fun convertToCardEntity(card: Card, bin: String): CardEntity {
        return card.toCardEntity(bin)
    }

    override suspend fun insertCard(card: Card, bin: String) {
        cardDao.insertCard(convertToCardEntity(card, bin))
    }

    override suspend fun getAllCards(): List<Card> {
        return cardDao.getAllCards().map { it.toCard() }

    }

}