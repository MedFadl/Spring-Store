package com.medhat.store.archived.notification;

import org.springframework.stereotype.Service;

@Service
public interface NotificationService {
    void sendNotification(String message);
    void sendRegistrationNotification(String message , String recipientEmail);
}
