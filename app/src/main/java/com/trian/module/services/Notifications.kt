package com.trian.module.services


import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.trian.module.MainActivity

import android.graphics.Bitmap

import androidx.core.content.ContextCompat.getSystemService

import android.graphics.BitmapFactory

import android.media.RingtoneManager
import android.net.Uri
import androidx.core.app.Person
import androidx.core.app.RemoteInput

import com.trian.module.R
import java.util.*

class Notifications {

    val NOTIFICATION_ID = 1

    val NOTIFICATION_CHANNEL_ID = "ChatsApp"


    fun Notify(context: Context, message: String, number: Int) {

       sendNotification(context,"Ini judul/Title","Ini isi pesannya","pesan dari");
    }




    fun sendNotification(
        context: Context,
        notificationTitle: String?,
        notificationBody: String?,
        from: String?,
    ) {
        val intent = Intent(context, MainActivity::class.java)
        intent.putExtra("uid", from)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val defaultSoundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val CHANNEL_ID = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "name",
                NotificationManager.IMPORTANCE_HIGH
            )
            CHANNEL_ID.description = NOTIFICATION_CHANNEL_ID
            CHANNEL_ID.enableLights(true)
            CHANNEL_ID.enableVibration(true)
            //CHANNEL_ID.setVibrationPattern(new long[]{100, 200 ,400 ,500,400,300,200,400,100});
            notificationManager.createNotificationChannel(CHANNEL_ID)
        }

        val notificationBuilder: Notification =
            NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(notificationTitle)
                .setContentText(notificationBody)
                .setDefaults(Notification.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setSound(defaultSoundUri)
                .setAutoCancel(true)
                .build()
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder)
    }


}