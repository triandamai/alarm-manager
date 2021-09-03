package com.trian.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
@Entity(tableName = "tb_alarm")
data class Alarm(
    @PrimaryKey(autoGenerate = true)
    var alarmId: Int?,
    var hour: Int,
    var minute: Int,
    var started: Boolean,
    var recurring: Boolean,
    var monday: Boolean,
    var tuesday: Boolean,
    var wednesday: Boolean,
    var thursday: Boolean,
    var friday: Boolean,
    var saturday: Boolean,
    var sunday: Boolean,
    var title: String

)
