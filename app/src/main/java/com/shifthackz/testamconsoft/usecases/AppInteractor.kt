package com.shifthackz.testamconsoft.usecases

import android.util.Log
import com.shifthackz.testamconsoft.usecases.repository.AppRepository
import com.shifthackz.testamconsoft.usecases.repository.database.entity.UserEntity
import com.shifthackz.testamconsoft.utils.Constants
import io.reactivex.Single

class AppInteractor(private val repository: AppRepository) {

    fun fetchUsers(): Single<List<UserEntity>> {
        return repository.fetchUsers()
            .doOnError { t -> Log.e(Constants.TAG_ERROR, t.message) }
    }

    fun fetchUserById(id: Int): Single<UserEntity> {
        return repository.fetchUserById(id)
            .doOnError { t -> Log.e(Constants.TAG_ERROR, t.message) }
    }
}