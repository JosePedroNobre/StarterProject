package com.josenobre.expensestracker.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.josenobre.expensestracker.R

class BottomNavigationBarWidget @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.widget_bottom_navigation_bar, this, false)
        val set = ConstraintSet()
        addView(view)
        set.clone(this)
    }
}