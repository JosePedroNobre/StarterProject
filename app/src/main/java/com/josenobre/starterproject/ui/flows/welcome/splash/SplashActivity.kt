package com.josenobre.starterproject.ui.flows.welcome.splash

import android.os.Handler
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.josenobre.starterproject.R
import com.josenobre.starterproject.ui.base.BaseActivity
import com.josenobre.starterproject.ui.common.NavigationManager
import javax.inject.Inject

class SplashActivity : com.josenobre.starterproject.ui.base.BaseActivity<com.josenobre.starterproject.ui.flows.welcome.splash.SplashVM>() {

    companion object {
        private const val SPLASH_DELAY: Long = 3000
    }

    @Inject
    lateinit var navigationManager: com.josenobre.starterproject.ui.common.NavigationManager

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var mDelayHandler: Handler? = null

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            // go to something after splash screen
        }
    }

    override fun layoutToInflate() = R.layout.activity_splash
    override fun defineViewModel() = ViewModelProviders.of(this, viewModelFactory).get(com.josenobre.starterproject.ui.flows.welcome.splash.SplashVM::class.java)
    override fun doOnCreated() {
        mDelayHandler = Handler()
        mDelayHandler!!.postDelayed(
            mRunnable,
            com.josenobre.starterproject.ui.flows.welcome.splash.SplashActivity.Companion.SPLASH_DELAY
        )
    }

    private fun finishApp() {
        Toast.makeText(this, "No permissions", Toast.LENGTH_LONG).show()
        finish()
    }
}