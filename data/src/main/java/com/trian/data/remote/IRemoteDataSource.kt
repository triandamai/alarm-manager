package com.trian.data.remote

import com.trian.domain.repository.BaseResponse
import com.trian.domain.entities.User
import retrofit2.http.POST

interface IRemoteDataSource {


    @POST("/login")
    suspend fun loginUser(): BaseResponse<List<User>>

}