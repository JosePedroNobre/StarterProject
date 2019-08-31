package com.josenobre.starterproject.ui.common

import android.content.Context
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.josenobre.starterproject.utils.DialogManager
import javax.inject.Inject

class NavigationManager @Inject constructor() {

    @Inject
    lateinit var dialogManager: com.josenobre.starterproject.utils.DialogManager

    companion object {
        // put bundle ids here
    }

    fun goToSomeActivity(context: Context) {}

    fun showMoviesDialog() {
        // Chose one
        // dialogManager.showAlertDialog(...)
        // dialogManager.generateCustomDialog(...)
    }

    private fun replaceFragment(
        fragment: Fragment,
        fragmentManager: FragmentManager,
        @IdRes containerId: Int
    ) {
        fragmentManager
            .beginTransaction()
            .replace(containerId, fragment, fragment.javaClass.name)
            .commitNow()
    }
}