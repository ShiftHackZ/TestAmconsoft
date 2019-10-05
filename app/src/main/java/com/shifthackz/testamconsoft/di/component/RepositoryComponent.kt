package com.shifthackz.testamconsoft.di.component

import com.shifthackz.testamconsoft.di.module.RepositoryModule
import com.shifthackz.testamconsoft.di.scope.RepositoryScope
import com.shifthackz.testamconsoft.usecases.repository.AppRepository
import dagger.Component

@RepositoryScope
@Component(modules = [RepositoryModule::class], dependencies = [ApiComponent::class, DatabaseComponent::class])
interface RepositoryComponent {
    val repository: AppRepository
}