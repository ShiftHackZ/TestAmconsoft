package com.shifthackz.testamconsoft.di.component

import com.shifthackz.testamconsoft.presentation.activities.main.MainActivity
import com.shifthackz.testamconsoft.di.module.ViewModelModule
import com.shifthackz.testamconsoft.di.scope.ViewModelScope
import com.shifthackz.testamconsoft.presentation.activities.detail.DetailActivity
import dagger.Component

@ViewModelScope
@Component(modules = [ViewModelModule::class], dependencies = [InteractorComponent::class])
interface ViewModelComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: DetailActivity)
}