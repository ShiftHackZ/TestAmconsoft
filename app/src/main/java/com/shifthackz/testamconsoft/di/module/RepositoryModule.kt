package com.shifthackz.testamconsoft.di.module

import com.shifthackz.testamconsoft.di.scope.RepositoryScope
import com.shifthackz.testamconsoft.usecases.repository.AppRepository
import com.shifthackz.testamconsoft.usecases.repository.database.AppDatabase
import com.shifthackz.testamconsoft.usecases.repository.server.ServerCommunicator
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @RepositoryScope
    @Provides
    internal fun providesRepository(communicator: ServerCommunicator, database: AppDatabase): AppRepository {
        return AppRepository(communicator, database)
    }
}