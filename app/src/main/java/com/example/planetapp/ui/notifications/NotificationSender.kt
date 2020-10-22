package com.example.planetapp.ui.notifications


interface NotificationSender {
    fun sendNotification(id: Int, text: String)
}