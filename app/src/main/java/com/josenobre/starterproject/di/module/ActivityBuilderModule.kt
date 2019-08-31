package com.josenobre.starterproject.di.module

import com.josenobre.starterproject.ui.flows.welcome.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesSplashActivity(): SplashActivity
}