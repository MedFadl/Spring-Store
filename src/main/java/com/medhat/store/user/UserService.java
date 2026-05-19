package com.medhat.store.user;


import com.medhat.store.notification.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private NotificationService notificationService;

    public UserService(UserRepository userRepository , NotificationService notificationService) {
        this.userRepository = userRepository;
        this.notificationService = notificationService;
    }

    public void registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null)
        {
            throw new IllegalArgumentException("That email exists >:c");
        }
        userRepository.save(user);
        notificationService.sendRegistrationNotification("Welcome to our store", user.email);
    }
}
