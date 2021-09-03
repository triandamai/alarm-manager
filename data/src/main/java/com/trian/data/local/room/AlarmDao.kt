package com.trian.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.trian.domain.entities.Alarm
import com.trian.domain.entities.User

/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
@SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
@Dao
interface AlarmDao {

    @Query("SELECT * FROM tb_alarm")
     fun getListAlarm():LiveData<List<Alarm>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAlarm(alarm: Alarm)
}