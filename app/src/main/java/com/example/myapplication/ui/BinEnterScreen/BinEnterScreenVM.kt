package com.example.myapplication.ui.BinEnterScreen

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.Card
import com.example.myapplication.data.network.GetBankCardInfoByApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BinEnterScreenVM : ViewModel() {
    private val _bin = MutableStateFlow("")
    val bin: StateFlow<String> = _bin
    private val _cardInfo = MutableStateFlow(Card())
    val cardInfo: StateFlow<Card> = _cardInfo
    fun onChangeBin(text: String) {
        this._bin.value = text
    }
    fun callApi() {
        viewModelScope.launch {
            val c = GetBankCardInfoByApi(_bin.value)
            _cardInfo.value = c
        }
        println("latasa2 ${_cardInfo.value}")
    }
}