package com.josenobre.expensestracker.di.module

import com.josenobre.expensestracker.ui.flows.login.activity.LoginActivity
import com.josenobre.expensestracker.ui.flows.main.activities.MainActivity
import com.josenobre.expensestracker.ui.flows.welcome.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributesLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity
}