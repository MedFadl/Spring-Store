package com.medhat.store.exercise;

import org.springframework.beans.factory.annotation.Qualifier;

public class NotificationManager {
    private NotificationService notificationService;
    NotificationManager(@Qualifier("SMS") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void sendNotification(String message) {
        notificationService.sendNotification(message);
    }

}
