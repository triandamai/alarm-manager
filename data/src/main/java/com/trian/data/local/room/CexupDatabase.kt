package com.trian.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.trian.domain.entities.Alarm
import com.trian.domain.entities.User

/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
@Database(
    entities = [User::class,Alarm::class],
    version = 23,
    exportSchema = false
)
abstract class CexupDatabase :RoomDatabase(){
    abstract fun userDao():UserDao
    abstract fun alarmDao():AlarmDao
    companion object{
        const val DATABASE_NAME = "cexup_db"
    }
}