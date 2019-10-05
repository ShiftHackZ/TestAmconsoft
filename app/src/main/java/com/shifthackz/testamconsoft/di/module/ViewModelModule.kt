package com.shifthackz.testamconsoft.di.module

import android.app.Application
import com.shifthackz.testamconsoft.App
import com.shifthackz.testamconsoft.di.scope.ViewModelScope
import com.shifthackz.testamconsoft.domain.AllUsersViewModel
import com.shifthackz.testamconsoft.domain.SingleUserViewModel
import com.shifthackz.testamconsoft.usecases.AppInteractor
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule(app: App) {

    internal var app: Application = app

    @ViewModelScope
    @Provides
    internal fun providesAllUserViewModel(interactor: AppInteractor): AllUsersViewModel {
        return AllUsersViewModel(app, interactor)
    }

    @ViewModelScope
    @Provides
    internal fun providesSingleViewModel(interactor: AppInteractor): SingleUserViewModel {
        return SingleUserViewModel(app, interactor)
    }
}