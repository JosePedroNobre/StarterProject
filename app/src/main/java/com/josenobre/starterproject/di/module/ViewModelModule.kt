package com.josenobre.starterproject.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.josenobre.starterproject.di.ViewModelFactory
import com.josenobre.starterproject.di.ViewModelKey
import com.josenobre.starterproject.ui.flows.welcome.splash.SplashVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: com.josenobre.starterproject.di.ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @com.josenobre.starterproject.di.ViewModelKey(com.josenobre.starterproject.ui.flows.welcome.splash.SplashVM::class)
    abstract fun bindsSplashVM(splashScreenVM: com.josenobre.starterproject.ui.flows.welcome.splash.SplashVM): ViewModel
}