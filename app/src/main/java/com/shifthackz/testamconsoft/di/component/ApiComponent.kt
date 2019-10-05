package com.shifthackz.testamconsoft.di.component

import com.shifthackz.testamconsoft.di.module.ApiModule
import com.shifthackz.testamconsoft.di.scope.ApiScope
import com.shifthackz.testamconsoft.usecases.repository.server.ServerCommunicator
import dagger.Component

@ApiScope
@Component(modules = [ApiModule::class])
interface ApiComponent {
    val serverCommunicator: ServerCommunicator
}