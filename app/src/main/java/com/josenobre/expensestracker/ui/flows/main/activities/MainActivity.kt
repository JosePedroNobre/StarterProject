package com.josenobre.expensestracker.ui.flows.main.activities

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.josenobre.expensestracker.R
import com.josenobre.expensestracker.ui.base.BaseActivity
import com.josenobre.expensestracker.ui.common.NavigationManager
import kotlinx.android.synthetic.main.widget_bottom_navigation_bar.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainActivityVM>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun containerId() = R.id.fragment_container

    override fun layoutToInflate() = R.layout.activity_main

    override fun defineViewModel() =
        ViewModelProviders.of(this, viewModelFactory).get(MainActivityVM::class.java)

    override fun doOnCreated() {
    }
}