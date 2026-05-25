package com.medhat.store;

import com.medhat.store.archived.OrderService;
import com.medhat.store.archived.user.UserService;
import com.medhat.store.models.Address;
import com.medhat.store.models.Profile;
import com.medhat.store.models.Tag;
import com.medhat.store.models.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        //We are going to use IOC (inversion of control) to make spring handle objects
        //Bean = Objects that are managed by spring

        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

        var registeration = context.getBean(UserService.class);
        //registeration.registerUser(new User("M@M.COM", 1234L, "123456", "Medhat"));


        var orderservice = context.getBean(OrderService.class);
        orderservice.placeOrder();

       //context.getBean(NotificationService.class).sendNotification("Done wewewew");

        //no need to handle it manually now.
        //var orderService = new OrderService(new WaffarhaPaymentService());
        //orderService.placeOrder();

        var user = User.builder()
                .email("M@M.COM")
                .password("123456")
                .name("Medhat")
                .build();

        var address = Address.builder()
                .street("123 Main St")
                .city("Anytown")
                .state("Any")
                .zip("12345")
                .build();
        var profile = Profile.builder()
                .loyaltyPoints(0)
                .build();

        user.setProfile(profile);
        profile.setUser(user);
        user.addAddress(address);

        var tag = new Tag("Normal User ");
        
        user.getTags().add(tag);
        tag.getUsers().add(user);
    }

}
