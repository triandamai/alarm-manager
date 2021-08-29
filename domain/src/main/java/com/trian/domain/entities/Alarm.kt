package com.trian.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "alarm_table")
data class Alarm(
    @PrimaryKey
    var alarmId: Int,
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
