package com.example.myapplication.data.mappers

import com.example.myapplication.data.database.CardEntity
import com.example.myapplication.data.model.Bank
import com.example.myapplication.data.model.Card
import com.example.myapplication.data.model.Country
import com.example.myapplication.data.model.Number


fun Card.toCardEntity(bin: String): CardEntity {
    return CardEntity(
        bin = bin,
        length = this.number.length,
        luhn = this.number.luhn,
        scheme = this.scheme,
        type = this.type,
        brand = this.brand,
        prepaid = this.prepaid,
        numeric = this.country.numeric,
        alpha2 = this.country.alpha2,
        name = this.country.name,
        emoji = this.country.emoji,
        currency = this.country.currency,
        latitude = this.country.latitude,
        longitude = this.country.longitude,
        bankName = this.bank.name,
        url = this.bank.url,
        phone = this.bank.phone,
        city = this.bank.city
    )
}

fun CardEntity.toCard(): Card {
    return Card(
        bin = bin,
        number = Number(this.length, this.luhn),
        scheme = this.scheme,
        type = this.type,
        brand = this.brand,
        prepaid = this.prepaid,
        country = Country(
            this.numeric,
            this.alpha2,
            this.name,
            this.emoji,
            this.currency,
            this.latitude,
            this.longitude
        ),
        bank = Bank(
            this.bankName,
            this.url,
            this.phone,
            this.city
        )
    )
}