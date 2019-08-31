package com.josenobre.starterproject.utils

import android.app.Application
import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesManager @Inject constructor() {

    @Inject
    lateinit var application: Application

    companion object {
        private const val PREFS_FILENAME = "my_project"
        private const val PREFS_ONE = "something"
    }

    private val sharedPreferences: SharedPreferences by lazy {
        application.getSharedPreferences(PREFS_FILENAME, 0)
    }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }

    fun setSomething(phase: String) {
        sharedPreferences.edit().putString(PREFS_ONE, phase).apply()
    }

    fun getSomething(): String? {
        return sharedPreferences.getString(PREFS_ONE, "")
    }
}