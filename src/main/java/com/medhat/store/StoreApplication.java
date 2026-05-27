package com.medhat.store;

import com.medhat.store.models.Address;
import com.medhat.store.models.Profile;
import com.medhat.store.models.Tag;
import com.medhat.store.models.User;
import com.medhat.store.repositories.UserRepository;
import com.medhat.store.transactions.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
    }

}
