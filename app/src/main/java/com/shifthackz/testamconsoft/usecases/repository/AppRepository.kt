package com.shifthackz.testamconsoft.usecases.repository

import com.shifthackz.testamconsoft.usecases.repository.database.AppDatabase
import com.shifthackz.testamconsoft.usecases.repository.database.entity.UserEntity
import com.shifthackz.testamconsoft.usecases.repository.server.ServerCommunicator
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AppRepository(private val communicator: ServerCommunicator, private val database: AppDatabase) {

    fun fetchUsers(): Single<List<UserEntity>> {
        return communicator.fetchUsers()
            .flatMap { response ->
                if (response.isSuccessful) {
                    database.userDao().insertList(response.body()!!)
                }
                Single.just(database.userDao().getAll())
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun fetchUserById(id: Int): Single<UserEntity> {
        return Single.just(database.userDao().getById(id))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}