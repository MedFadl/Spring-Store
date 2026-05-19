package com.medhat.store.notification;

import org.springframework.stereotype.Service;

@Service
public interface NotificationService {
    void sendNotification(String message);
    void sendRegistrationNotification(String message , String recipientEmail);
}
