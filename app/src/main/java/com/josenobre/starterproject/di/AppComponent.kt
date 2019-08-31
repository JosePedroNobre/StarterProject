package com.josenobre.starterproject.di

import android.app.Application
import com.josenobre.starterproject.App
import com.josenobre.starterproject.di.module.ActivityBuilderModule
import com.josenobre.starterproject.di.module.FragmentBuilderModule
import com.josenobre.starterproject.di.module.NetworkModule
import com.josenobre.starterproject.di.module.ViewModelModule
import com.josenobre.starterproject.di.module.UtilsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        com.josenobre.starterproject.di.module.ActivityBuilderModule::class,
        com.josenobre.starterproject.di.module.FragmentBuilderModule::class,
        com.josenobre.starterproject.di.module.ViewModelModule::class,
        com.josenobre.starterproject.di.module.NetworkModule::class,
        com.josenobre.starterproject.di.module.UtilsModule::class
    ]
)
interface AppComponent : AndroidInjector<com.josenobre.starterproject.App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): com.josenobre.starterproject.di.AppComponent.Builder

        fun build(): com.josenobre.starterproject.di.AppComponent
    }

    override fun inject(app: com.josenobre.starterproject.App)
}