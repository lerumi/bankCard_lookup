package com.example.myapplication.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Bank(
    val name: String = "-",
    val url: String = "-",
    val phone: String = "-",
    val city: String = "-"
)
