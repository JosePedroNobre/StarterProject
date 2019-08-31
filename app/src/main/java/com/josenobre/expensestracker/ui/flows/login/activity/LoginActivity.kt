package com.josenobre.expensestracker.ui.flows.login.activity

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.josenobre.expensestracker.R
import com.josenobre.expensestracker.ui.base.BaseActivity
import com.josenobre.expensestracker.ui.common.NavigationManager
import javax.inject.Inject

class LoginActivity : BaseActivity<LoginActivityVM>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun containerId() = R.id.fragment_container

    override fun loadInitialFragment() {
    }

    override fun layoutToInflate() = R.layout.activity_login

    override fun defineViewModel() =
        ViewModelProviders.of(this, viewModelFactory).get(LoginActivityVM::class.java)

    override fun doOnCreated() {}
}