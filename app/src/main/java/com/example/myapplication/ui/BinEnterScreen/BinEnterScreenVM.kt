package com.example.myapplication.ui.BinEnterScreen

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.interactors.CardInteractor
import com.example.myapplication.data.interactors.CardInteractorImpl
import com.example.myapplication.data.model.Card
import com.example.myapplication.data.network.GetBankCardInfoByApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BinEnterScreenVM @Inject constructor(
    val interactor: CardInteractorImpl
) : ViewModel() {
    private val _bin = MutableStateFlow("")
    val bin: StateFlow<String> = _bin
    private val _cardInfo = MutableStateFlow(Card())
    val cardInfo: StateFlow<Card> = _cardInfo
    fun onChangeBin(text: String) {
        this._bin.value = text
    }

    fun callApi() {
        viewModelScope.launch {
            val card = GetBankCardInfoByApi(_bin.value)
            _cardInfo.value = card
            saveToDatabase(card)
        }
        println("latasa2 ${_cardInfo.value}")
    }

    private fun saveToDatabase(card: Card) {
        viewModelScope.launch {
            interactor.insertCard(card, _bin.value)
        }
    }
}