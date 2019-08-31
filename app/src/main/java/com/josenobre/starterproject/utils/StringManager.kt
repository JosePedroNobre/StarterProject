package com.josenobre.starterproject.utils

import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.util.Patterns
import javax.inject.Inject

class StringManager @Inject constructor() {

    fun isEmailValid(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun applyUnderline(value: String, startIndex: Int, endIndex: Int): SpannableString {
        val retrievePassword = SpannableString(value)
        retrievePassword.setSpan(UnderlineSpan(), startIndex, endIndex, SpannableString.SPAN_INCLUSIVE_INCLUSIVE)
        return retrievePassword
    }
}