package com.shifthackz.testamconsoft.di.component

import com.shifthackz.testamconsoft.di.module.DatabaseModule
import com.shifthackz.testamconsoft.usecases.repository.database.AppDatabase
import dagger.Component

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    val database: AppDatabase
}