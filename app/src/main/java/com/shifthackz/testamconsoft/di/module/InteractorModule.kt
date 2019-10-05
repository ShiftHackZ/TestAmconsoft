package com.shifthackz.testamconsoft.di.module

import com.shifthackz.testamconsoft.di.scope.InteractorScope
import com.shifthackz.testamconsoft.usecases.AppInteractor
import com.shifthackz.testamconsoft.usecases.repository.AppRepository
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {
    @InteractorScope
    @Provides
    internal fun providesInteractor(repository: AppRepository): AppInteractor {
        return AppInteractor(repository)
    }
}