package com.josenobre.expensestracker.ui.common

import android.content.Context
import android.content.Intent
import androidx.annotation.IdRes
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.josenobre.expensestracker.ui.flows.login.activity.LoginActivity
import com.josenobre.expensestracker.utils.DialogManager
import javax.inject.Inject

class NavigationManager @Inject constructor() {

    @Inject
    lateinit var dialogManager: DialogManager

    companion object {
        // put bundle ids here
    }

    fun goToLoginActivity(context: Context) {
        val intent = Intent(context, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(context, intent, null)
    }

    fun showMoviesDialog() {
        // Chose one
        // dialogManager.showAlertDialog(...)
        // dialogManager.generateCustomDialog(...)
    }

    private fun replaceFragment(fragment: Fragment, fragmentManager: FragmentManager, @IdRes containerId: Int) {
        fragmentManager
            .beginTransaction()
            .replace(containerId, fragment, fragment.javaClass.name)
            .commitNow()
    }
}