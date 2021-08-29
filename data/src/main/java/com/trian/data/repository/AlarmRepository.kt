package com.trian.data.repository

import com.trian.common.utils.network.NetworkStatus
import com.trian.data.coroutines.DispatcherProvider
import com.trian.data.local.room.CexupDatabase
import com.trian.data.remote.IRemoteDataSource
import com.trian.data.utils.networkBoundResource
import com.trian.domain.entities.User
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AlarmRepository(
    private val dispatcherProvider: DispatcherProvider,
    private val cexupDatabase: CexupDatabase,
    private val remoteDataSource: IRemoteDataSource,
) {
    @ExperimentalCoroutinesApi
     suspend fun getAllUsers(): Flow<NetworkStatus<List<User>>> {
        return networkBoundResource(
            query = {fetchLocalUsers()},
            fetch = {},
            saveFetchResult = {
                response ->
             //   cexupDatabase.userDao().insert(response.data!!)

            },
            clearData = {}
        )
    }

    private fun fetchLocalUsers():Flow<List<User>> = flow {
        emit(cexupDatabase.userDao().getAll())
    }

}