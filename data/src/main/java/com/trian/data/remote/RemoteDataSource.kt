package com.trian.data.remote

import com.trian.domain.repository.BaseResponse
import com.trian.domain.entities.User

/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
class RemoteDataSource(private val apiServices: ApiServices): IRemoteDataSource {


    override suspend fun loginUser(): BaseResponse<List<User>> = apiServices.loginUser()


}