package com.example.myapplication.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.data.model.Bank
import com.example.myapplication.data.model.Country
import com.example.myapplication.data.model.Number

@Entity
data class CardEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val bin: String = "",
    val length: Int = 0,
    val luhn: Boolean = false,
    val scheme: String = "-",
    val type: String = "-",
    val brand: String = "-",
    val prepaid: Boolean = false,
    val numeric: String = "-",
    val alpha2: String = "-",
    val name: String = "-",
    val emoji: String = "-",
    val currency: String = "-",
    val latitude: Int = 0,
    val longitude: Int = 0,
    val bankName: String = "-",
    val url: String = "-",
    val phone: String = "-",
    val city: String = "-"
)
