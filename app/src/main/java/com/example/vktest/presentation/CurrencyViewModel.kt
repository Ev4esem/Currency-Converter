package com.example.vktest.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vktest.domain.Result
import com.example.vktest.domain.entities.Currency
import com.example.vktest.domain.use_cases.ConverterCurrencyUseCase
import com.example.vktest.domain.use_cases.GetCurrencyByIdUseCase
import com.example.vktest.domain.use_cases.GetCurrencyListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val getCurrencyByIdUseCase: GetCurrencyByIdUseCase,
    private val getCurrencyListUseCase: GetCurrencyListUseCase,
    private val converterCurrencyUseCase: ConverterCurrencyUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    init {
        getCurrency()
    }

    private fun getCurrency() {
        viewModelScope.launch {
            getCurrencyListUseCase()
                .map { Result.Success(it) as Result }
                .onStart { emit(Result.Loading) }
                .catch { emit(Result.Error) }
                .collect {
                    when (it) {
                        is Result.Error -> {
                            _uiState.update { currentState ->
                                currentState.copy(
                                    error = "Ой!Что то пошло не так:("
                                )
                            }
                        }

                        is Result.Loading -> {
                            _uiState.update { currentState ->
                                currentState.copy(
                                    loading = true
                                )
                            }
                        }

                        is Result.Success -> {
                            _uiState.update { currentState ->
                                currentState.copy(
                                    currencyList = it.data
                                )
                            }
                        }
                    }
                }
        }
    }

    fun converter(one: String?, two: String?) {
        if (!checkValid(one, two)) return
        val oneNumber = one?.toDouble() ?: 0.0
        val twoNumber = two?.toDouble() ?: 0.0
        val number = converterCurrencyUseCase(oneNumber, twoNumber)
        _uiState.update { currentState ->
            currentState.copy(
                number = number
            )
        }
    }

    fun checkValid(one: String?, two: String?): Boolean {
        if (one == null && two == null) return false
        return true
    }

}

data class UiState(
    val currencyList: List<Currency> = emptyList(),
    val error: String? = null,
    val loading: Boolean = false,
    val number: Double = 0.0
)