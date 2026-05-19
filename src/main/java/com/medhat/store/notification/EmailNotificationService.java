package com.medhat.store.notification;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("Email")
@Primary
public class EmailNotificationService implements NotificationService{

    @Value("${mail.host}")
    private String host;

    @Value("${mail.port}")
    private String port;

    @Override
    public void sendNotification(String message) {
        System.out.println("Email Notification Service");
        System.out.println("Message: " + message);
    }

    @Override
    public void sendRegistrationNotification(String message, String recipientEmail) {
        System.out.println("Sending registration notification to " + recipientEmail);
        System.out.println("Message: " + message);
        System.out.println("Host: " + host + " Port: " + port);
    }

}
