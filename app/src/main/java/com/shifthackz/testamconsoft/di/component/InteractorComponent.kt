package com.shifthackz.testamconsoft.di.component

import com.shifthackz.testamconsoft.di.module.InteractorModule
import com.shifthackz.testamconsoft.di.scope.InteractorScope
import com.shifthackz.testamconsoft.usecases.AppInteractor
import dagger.Component

@InteractorScope
@Component(modules = [InteractorModule::class], dependencies = [RepositoryComponent::class])
interface InteractorComponent {
    val interactor: AppInteractor
}