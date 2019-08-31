package com.josenobre.starterproject

import android.app.Activity
import android.content.Context
import androidx.multidex.MultiDexApplication
import com.josenobre.starterproject.di.DaggerAppComponent
import com.squareup.leakcanary.LeakCanary
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App @Inject constructor() : HasActivityInjector, MultiDexApplication() {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = activityInjector

    override fun onCreate() {
        super.onCreate()
        LeakCanary.install(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        DaggerAppComponent.builder().application(this).build().inject(this)
    }
}