package com.josenobre.starterproject.di.module

import com.josenobre.starterproject.ui.common.NavigationManager
import com.josenobre.starterproject.utils.DateManager
import com.josenobre.starterproject.utils.DialogManager
import com.josenobre.starterproject.utils.KeyboardManager
import com.josenobre.starterproject.utils.PreferencesManager
import com.josenobre.starterproject.utils.StringManager
import com.josenobre.starterproject.utils.CurrencyManager
import com.josenobre.starterproject.utils.PermissionsManager
import com.josenobre.starterproject.utils.EditTextManager
import com.josenobre.starterproject.utils.FileManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {

    @Singleton
    @Provides
    fun providesNavigationManager() = com.josenobre.starterproject.ui.common.NavigationManager()

    @Singleton
    @Provides
    fun providesPreferencesManager() = PreferencesManager()

    @Singleton
    @Provides
    fun providesDateManager() = com.josenobre.starterproject.utils.DateManager()

    @Singleton
    @Provides
    fun providesKeyboardManager() = KeyboardManager()

    @Singleton
    @Provides
    fun providesDialogManager() = com.josenobre.starterproject.utils.DialogManager()

    @Singleton
    @Provides
    fun providesStringManager() = StringManager()

    @Singleton
    @Provides
    fun providesCurrencyManager() = com.josenobre.starterproject.utils.CurrencyManager()

    @Singleton
    @Provides
    fun providesPermissionsManager() = PermissionsManager()

    @Singleton
    @Provides
    fun providesEditTextManager() = EditTextManager()

    @Singleton
    @Provides
    fun providesFilemanager() = FileManager()
}
