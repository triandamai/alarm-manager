package com.trian.data.di


import com.google.gson.Gson
import com.trian.data.coroutines.DefaultDispatcherProvider
import com.trian.data.coroutines.DispatcherProvider
import com.trian.data.local.room.CexupDatabase
import com.trian.data.remote.ApiServices
import com.trian.data.remote.IRemoteDataSource
import com.trian.data.remote.RemoteDataSource
import com.trian.data.repository.AlarmRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent

/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
@Module
@InstallIn(SingletonComponent::class, ActivityComponent::class)
object DataModule {
    @Provides
    internal fun provideDispatcherProvider(): DispatcherProvider = DefaultDispatcherProvider()

    @Provides
    internal fun provideGson() = Gson()

    @Provides
    fun provideAppRemoteDataSource(apiServices: ApiServices): IRemoteDataSource {
        return RemoteDataSource(apiServices)
    }


    @Provides
    fun provideRepository(
        dispatcherProvider: DispatcherProvider,
        remoteDataSource: IRemoteDataSource,
        database: CexupDatabase
    ): AlarmRepository {
        return AlarmRepository(dispatcherProvider, database, remoteDataSource)
    }
}