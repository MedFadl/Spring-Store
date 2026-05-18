package com.medhat.store.exercise;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("Email")
@Primary
public class EmailNotificationService implements NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("Email Notification Service");
        System.out.println("Message: " + message);
    }
}
