package com.josenobre.expensestracker.di.module

import com.josenobre.expensestracker.ui.common.NavigationManager
import com.josenobre.expensestracker.utils.DateManager
import com.josenobre.expensestracker.utils.DialogManager
import com.josenobre.expensestracker.utils.KeyboardManager
import com.josenobre.expensestracker.utils.PreferencesManager
import com.josenobre.expensestracker.utils.StringManager
import com.josenobre.expensestracker.utils.CurrencyManager
import com.josenobre.expensestracker.utils.PermissionsManager
import com.josenobre.expensestracker.utils.EditTextManager
import com.josenobre.expensestracker.utils.FileManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {

    @Singleton
    @Provides
    fun providesNavigationManager() = NavigationManager()

    @Singleton
    @Provides
    fun providesPreferencesManager() = PreferencesManager()

    @Singleton
    @Provides
    fun providesDateManager() = DateManager()

    @Singleton
    @Provides
    fun providesKeyboardManager() = KeyboardManager()

    @Singleton
    @Provides
    fun providesDialogManager() = DialogManager()

    @Singleton
    @Provides
    fun providesStringManager() = StringManager()

    @Singleton
    @Provides
    fun providesCurrencyManager() = CurrencyManager()

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
