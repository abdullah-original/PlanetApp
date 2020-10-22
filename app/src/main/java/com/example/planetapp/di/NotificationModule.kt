package com.example.planetapp.di

import android.content.Context
import com.example.planetapp.ui.notifications.FavouritePlanetNotification
import com.example.planetapp.ui.notifications.NotificationSender
import dagger.Module
import dagger.Provides

@Module
class NotificationModule {
    @Provides
    fun provideNotification(context: Context): NotificationSender {
        return FavouritePlanetNotification(context)
    }
}