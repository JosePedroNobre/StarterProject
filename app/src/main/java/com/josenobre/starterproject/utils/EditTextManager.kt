package com.josenobre.starterproject.utils

import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.widget.AppCompatEditText
import javax.inject.Inject

class EditTextManager @Inject constructor() {

    fun afterTextChanged(afterTextChanged: (String) -> Unit, editText: AppCompatEditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(editable: Editable?) {
                afterTextChanged(editable.toString())
            }
        })
    }
}

fun AppCompatEditText.validateOnFocusChanged(validator: (String) -> Boolean, postRunnable: Runnable?) {
    this.setOnFocusChangeListener { v, hasFocus ->
        v as AppCompatEditText
        validator(v.text.toString())
        if (!hasFocus) {
            postRunnable?.run()
        }
    }
}