package com.example.planetapp.ui.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.planetapp.R

class FavouritePlanetNotification(private val context: Context) : NotificationSender {
    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mChannel = NotificationChannel(
                "FavouritePlanets",
                "Favourite Planets",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Favourite Planet Notifications"
            }
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }

    override fun sendNotification(id: Int, text: String) {
        var builder = NotificationCompat.Builder(context, "FavouritePlanets")
            .setSmallIcon(R.drawable.mars)
            .setContentTitle("Changed a Favourite Planet")
            .setLargeIcon(
                BitmapFactory.decodeResource(context.getResources(),
                R.drawable.mars))
            .setContentText(text)
            .setAutoCancel(true)

        NotificationManagerCompat.from(context).notify(id, builder.build())
    }
}