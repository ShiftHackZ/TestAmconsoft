package com.shifthackz.testamconsoft.domain

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.LiveData
import com.shifthackz.testamconsoft.presentation.widget.SingleLiveEvent
import com.shifthackz.testamconsoft.usecases.AppInteractor
import com.shifthackz.testamconsoft.usecases.repository.database.entity.UserEntity

class AllUsersViewModel(app: Application, private val interactor: AppInteractor): BaseViewModel(app) {

    private val liveDataItems = SingleLiveEvent<List<UserEntity>>()

    @SuppressLint("CheckResult")
    fun getAllItems() {
        interactor.fetchUsers()?.subscribe({ list -> liveDataItems.value = list }, { liveDataItems.value = null })
    }

    fun getLiveDataItems(): LiveData<List<UserEntity>> {
        return liveDataItems
    }
}