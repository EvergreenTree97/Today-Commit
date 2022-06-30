package com.evergreen.todaycommit.firebase

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.evergreen.todaycommit.R
import com.evergreen.todaycommit.presentation.main.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseMessagingServiceImpl : FirebaseMessagingService() {
    companion object {
        private const val TAG = "FirebaseMessaging"
        private const val CHANNEL_ID = "github_notification"
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "Refreshed token: $token")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d(TAG, "Message data : ${remoteMessage.data}")
        Log.d(TAG, "Message noti : ${remoteMessage.notification}")
        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")

        }
        if (remoteMessage.data.isNotEmpty()) {
            Log.d(TAG, "Message Notification Body: ${remoteMessage.data}")
            val type = remoteMessage.data["type"]?.let { NotificationType.valueOf(it) } ?: run {
                NotificationType.NORMAL  //type 이 null 이면 NORMAL type 으로 처리
            }
            val title = remoteMessage.data["title"]
            val message = remoteMessage.data["message"]
            sendNotification(type, title, message)
        }
    }

    private fun sendNotification(
        type: NotificationType,
        title: String?,
        message: String?
    ) {
        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //Oreo(26) 이상 버전에는 channel 필요
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                getString(R.string.channel_name),
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        //알림 생성
        NotificationManagerCompat.from(this)
            .notify((System.currentTimeMillis()/100).toInt(), createNotification(type, title, message))  //알림이 여러개 표시되도록 requestCode 를 추가
    }

    /* 알림 설정 메서드 */
    private fun createNotification(
        type: NotificationType,
        title: String?,
        message: String?
    ): Notification {

        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("notificationType", " ${type.title} 타입 ")
            addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        }
        val pendingIntent = PendingIntent.getActivity(this, (System.currentTimeMillis()/100).toInt(), intent, FLAG_UPDATE_CURRENT)  //알림이 여러개 표시되도록 requestCode 를 추가

        val notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        //type 에 따라 style 설정
        when (type) {
            NotificationType.NORMAL -> Unit
            NotificationType.EXPANDABLE -> {
                notificationBuilder.setStyle(
                    NotificationCompat.BigTextStyle()
                        .bigText("$message 😀")
                )
            }
        }
        return notificationBuilder.build()
    }
}