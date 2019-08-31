package com.josenobre.expensestracker.ui.flows.welcome.splash

import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.josenobre.expensestracker.R
import com.josenobre.expensestracker.ui.base.BaseActivity
import com.josenobre.expensestracker.ui.common.NavigationManager
import javax.inject.Inject

class SplashActivity : BaseActivity<SplashVM>() {

    companion object {
        private const val SPLASH_DELAY: Long = 3000
    }

    @Inject
    lateinit var navigationManager: NavigationManager

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var mDelayHandler: Handler? = null

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            navigationManager.goToLoginActivity(applicationContext)
        }
    }

    override fun layoutToInflate() = R.layout.activity_splash
    override fun defineViewModel() = ViewModelProviders.of(this, viewModelFactory).get(SplashVM::class.java)
    override fun doOnCreated() {
        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(
            mRunnable,
            SPLASH_DELAY
        )
    }

    private fun finishApp() {
        Toast.makeText(this, "No permissions", Toast.LENGTH_LONG).show()
        finish()
    }
}