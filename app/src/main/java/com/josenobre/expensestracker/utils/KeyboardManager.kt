package com.josenobre.expensestracker.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import javax.inject.Inject

/**
 * @context This utility class allows the user to take full control of the keyboard
 */
class KeyboardManager @Inject constructor() {

    /**
     * @param v -> Pass the view of the edit text and the requireContext()
     */
    fun showKeyboard(v: View, context: Context) {
        (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).showSoftInput(
            v, InputMethodManager.SHOW_IMPLICIT
        )
    }

    /**
     * @param v -> Pass the view of the edit text and the requireContext()
     */
    fun hideKeyboard(v: View, context: Context) {
        (context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
            v.windowToken,
            0
        )
    }
}