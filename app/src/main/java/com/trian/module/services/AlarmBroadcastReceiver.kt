package com.trian.module.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
/**
 * Entry point Activity of App
 * Author Trian Damai
 * Created at 03/09/2021
 * **/
@AndroidEntryPoint
class AlarmBroadcastReceiver : BroadcastReceiver() {
    @Inject
    lateinit var persistence: Persistence

    override fun onReceive(context: Context?, intent: Intent?) {

            Log.e("Receive ","${intent?.action}")
            if (intent!!.action.equals("com.tester.alarmmanager")){
                var b=intent.extras
                // Toast.makeText(context,b.getString("message"),Toast.LENGTH_LONG).show()
                val notifyMe=Notifications()
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    notifyMe.Notify(context!!, b!!.getString("message")!!,10)
                }
            }
            else if(intent!!.action.equals("android.intent.action.BOOT_COMPLETED")){


                persistence.setAlarm()
            }


    }

}