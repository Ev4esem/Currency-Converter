package com.example.vktest.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vktest.domain.Response
import com.example.vktest.domain.entities.Data
import com.example.vktest.domain.use_cases.GetCurrencyListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val getCurrencyListUseCase: GetCurrencyListUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState> get() = _uiState
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        val currentState = _uiState.value
        _uiState.value = UiState(responseState = Response.Error)
    }

    init {
        getCurrency()
    }

    private fun getCurrency() {
        _uiState.value = UiState(responseState = Response.Loading)
        viewModelScope.launch(exceptionHandler) {
            delay(2000)
            val data = getCurrencyListUseCase().data
            val currencyList = currencyList(data)
            val currencyName = currencyList.map { it.name }
            _uiState.value = UiState(
                currencyName = currencyName,
                currencyList = currencyList,
                responseState = Response.Success
            )
        }
    }

    private fun currencyList(data: Data): List<Currency> {
        return listOf(
            Currency(data.ADA.code, data.ADA.value),
            Currency(data.AED.code, data.AED.value),
            Currency(data.ALL.code, data.ALL.value),
        )
    }

    fun converter(amount: Double, source: Currency, target: Currency): Double {
        val amountInBaseCurrency = amount / source.value
        return amountInBaseCurrency * target.value
    }

}

data class UiState(
    val currencyName: List<String> = emptyList(),
    val currencyList: List<Currency> = emptyList(),
    val responseState: Response = Response.Loading,
)

data class Currency(val name: String, val value: Double)