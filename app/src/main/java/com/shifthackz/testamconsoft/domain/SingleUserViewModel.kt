package com.shifthackz.testamconsoft.domain

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.LiveData
import com.shifthackz.testamconsoft.presentation.widget.SingleLiveEvent
import com.shifthackz.testamconsoft.usecases.AppInteractor
import com.shifthackz.testamconsoft.usecases.repository.database.entity.UserEntity

class SingleUserViewModel (app: Application, private val interactor: AppInteractor): BaseViewModel(app) {

    private val liveDataItem = SingleLiveEvent<UserEntity>()

    @SuppressLint("CheckResult")
    fun getUser(id: Int) {
        interactor.fetchUserById(id)?.subscribe { item -> liveDataItem.value = item }
    }

    fun getLiveDataItem(): LiveData<UserEntity> {
        return liveDataItem
    }
}