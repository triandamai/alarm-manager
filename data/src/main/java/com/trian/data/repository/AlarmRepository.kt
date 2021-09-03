package com.trian.data.repository

import androidx.lifecycle.LiveData
import com.trian.common.utils.network.NetworkStatus
import com.trian.data.coroutines.DispatcherProvider
import com.trian.data.local.room.CexupDatabase
import com.trian.data.remote.IRemoteDataSource
import com.trian.data.utils.networkBoundResource
import com.trian.domain.entities.Alarm
import com.trian.domain.entities.User
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
class AlarmRepository(
    private val dispatcherProvider: DispatcherProvider,
    private val cexupDatabase: CexupDatabase,
    private val remoteDataSource: IRemoteDataSource,
) {

    suspend fun getListAlarm():LiveData<List<Alarm>>  = cexupDatabase.alarmDao().getListAlarm()

    suspend fun insertAlarm(alarm: Alarm) = cexupDatabase.alarmDao().insertAlarm(alarm)
}