package com.trian.data.remote

import com.trian.domain.repository.BaseResponse
import com.trian.domain.entities.User
import retrofit2.http.POST

/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
interface IRemoteDataSource {


    @POST("/login")
    suspend fun loginUser(): BaseResponse<List<User>>

}