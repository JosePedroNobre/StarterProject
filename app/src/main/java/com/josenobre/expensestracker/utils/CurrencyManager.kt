package com.josenobre.expensestracker.utils

import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale
import javax.inject.Inject

class CurrencyManager @Inject constructor() {

    companion object {

        private const val CURRENCY_SYMBOL = ""
        private const val CURRENCY_DECIMAL_SEPARATOR = ','
    }

    private val numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault())

    init {
        val decimalFormatSymbols = (numberFormat as DecimalFormat).decimalFormatSymbols
        decimalFormatSymbols.currencySymbol = CURRENCY_SYMBOL
        decimalFormatSymbols.monetaryDecimalSeparator = CURRENCY_DECIMAL_SEPARATOR
        numberFormat.decimalFormatSymbols = decimalFormatSymbols
    }

    fun format(value: Float?) = if (value != null) numberFormat.format(value) else ""
}