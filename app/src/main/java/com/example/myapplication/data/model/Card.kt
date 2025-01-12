package com.example.myapplication.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Card(
    val bin: String = "",
    val number: Number = Number(),
    val scheme: String = "-",
    val type: String = "-",
    val brand: String = "-",
    val prepaid: Boolean = false,
    val country: Country = Country(),
    val bank: Bank = Bank()
)
