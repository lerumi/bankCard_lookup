package com.example.myapplication.ui.QueryListScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.data.interactors.CardInteractor
import com.example.myapplication.data.interactors.CardInteractorImpl
import com.example.myapplication.data.model.Card
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QueryListScreenVM @Inject constructor(
    private val interactor: CardInteractorImpl
) : ViewModel() {
    private val _queryList = MutableStateFlow<List<Card>>(emptyList())
    val queryList: StateFlow<List<Card>> = _queryList
    fun loadQueryList() {
        viewModelScope.launch {
            val queryListA = interactor.getAllCards()
            _queryList.value = queryListA
        }
    }

}