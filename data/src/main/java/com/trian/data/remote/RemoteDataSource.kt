package com.trian.data.remote

import com.trian.domain.repository.BaseResponse
import com.trian.domain.entities.User


class RemoteDataSource(private val apiServices: ApiServices): IRemoteDataSource {


    override suspend fun loginUser(): BaseResponse<List<User>> = apiServices.loginUser()


}