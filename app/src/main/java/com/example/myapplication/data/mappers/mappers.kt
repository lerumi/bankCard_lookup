package com.example.myapplication.data.mappers

import com.example.myapplication.data.database.CardEntity
import com.example.myapplication.data.model.Card

fun Card.toCardEntity(bin: String): CardEntity{
    return CardEntity(
        bin = bin,
        number = this.number
    )
}