package com.example.vktest.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.vktest.R
import com.example.vktest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<CurrencyViewModel>()

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupSpinner()
        binding.bConverter.setOnClickListener {
            viewModel.uiState.observe(this) {
                val sourceCurrency = it.currencyList[binding.spinCurrencyOne
                    .selectedItemPosition]
                val targetCurrency = it.currencyList[binding.spinCurrencyTwo
                    .selectedItemPosition]
                val amount = binding.amountEt.text.toString().toDoubleOrNull()
                if (amount != null) {
                    val result = viewModel.converter(amount, sourceCurrency, targetCurrency)
                    binding.tvResult.text = result.toString()
                } else {
                    Toast.makeText(this, "Please enter a valid amount", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun setupSpinner() {
        viewModel.uiState.observe(this) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                it.currencyName
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinCurrencyOne.adapter = adapter
            binding.spinCurrencyTwo.adapter = adapter
        }
    }

}