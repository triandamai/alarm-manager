package com.trian.module.services

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log

import java.util.*
/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
class Persistence{

    var context: Context?=null
    var sharedRef: SharedPreferences?=null
    constructor(context:Context){
        this.context=context
       sharedRef=context.getSharedPreferences("myref",Context.MODE_PRIVATE)
    }

    fun SaveData(hour:Int,minute:Int){
       var editor=sharedRef!!.edit()
        editor.putInt("hour",hour)
        editor.putInt("minute",minute)
        editor.commit()
    }

    fun  getHour():Int{
        return sharedRef!!.getInt("hour",0)
    }
    fun  getMinute():Int{
        return sharedRef!!.getInt("minute",0)
    }

    fun setAlarm(){
        val hour:Int=getHour()
         val minute:Int=getMinute()
        val calender= Calendar.getInstance()
        calender.set(Calendar.HOUR_OF_DAY,hour)
        calender.set(Calendar.MINUTE,minute)
        calender.set(Calendar.SECOND,0)

        val am= context!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager

        var intent= Intent(context,AlarmBroadcastReceiver::class.java)
        intent.putExtra("message"," alarm time")
        intent.action="com.tester.alarmmanager"
        val pi= PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)


        Log.e("SET","$hour -> $minute")
        am.setWindow(AlarmManager.RTC_WAKEUP,calender.timeInMillis,
                AlarmManager.INTERVAL_DAY,pi)



    }
}