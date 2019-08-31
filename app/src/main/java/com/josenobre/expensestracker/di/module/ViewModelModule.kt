package com.josenobre.expensestracker.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.josenobre.expensestracker.di.ViewModelFactory
import com.josenobre.expensestracker.di.ViewModelKey
import com.josenobre.expensestracker.ui.flows.welcome.splash.SplashVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashVM::class)
    abstract fun bindsSplashVM(splashScreenVM: SplashVM): ViewModel
}