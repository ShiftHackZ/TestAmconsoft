package com.shifthackz.testamconsoft.usecases.repository.server

import com.shifthackz.testamconsoft.usecases.repository.database.entity.UserEntity
import com.shifthackz.testamconsoft.utils.RxUtils
import io.reactivex.Single
import retrofit2.Response

class ServerCommunicator(private val apiService: ApiService) {

    fun fetchUsers(): Single<Response<List<UserEntity>>?> {
        return apiService.fetchUsers()
            .compose(RxUtils.singleTransformer())
    }

}