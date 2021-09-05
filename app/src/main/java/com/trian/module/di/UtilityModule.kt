package com.trian.module.di

import android.content.Context
import androidx.room.Room
import com.trian.data.local.room.CexupDatabase
import com.trian.module.services.Persistence
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/

@InstallIn(SingletonComponent::class)
@Module
object UtilityModule {
    //for test
    @Provides
    fun providePersistence(@ApplicationContext appContext: Context): Persistence {
        return Persistence(appContext)
    }
}