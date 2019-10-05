package com.shifthackz.testamconsoft.usecases.repository.server

import com.shifthackz.testamconsoft.usecases.repository.database.entity.UserEntity
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/users")
    fun fetchUsers(): Single<Response<List<UserEntity>>?>
}