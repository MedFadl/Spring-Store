package com.medhat.store.archived.notification;

import org.springframework.stereotype.Service;

@Service("SMS")
public class SMSNotificationService implements NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("SMS Notification Service");
        System.out.println("Message: " + message);
    }

    @Override
    public void sendRegistrationNotification(String message, String recipientEmail) {

    }
}
