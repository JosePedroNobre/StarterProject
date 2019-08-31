package com.josenobre.expensestracker.di

import android.app.Application
import com.josenobre.expensestracker.App
import com.josenobre.expensestracker.di.module.ActivityBuilderModule
import com.josenobre.expensestracker.di.module.FragmentBuilderModule
import com.josenobre.expensestracker.di.module.NetworkModule
import com.josenobre.expensestracker.di.module.ViewModelModule
import com.josenobre.expensestracker.di.module.UtilsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        FragmentBuilderModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        UtilsModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: App)
}