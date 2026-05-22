package com.medhat.store;

import com.medhat.store.archived.OrderService;
import com.medhat.store.archived.user.User;
import com.medhat.store.archived.user.UserService;
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
        registeration.registerUser(new User("M@M.COM", 1234L, "123456", "Medhat"));


        var orderservice = context.getBean(OrderService.class);
        orderservice.placeOrder();

       //context.getBean(NotificationService.class).sendNotification("Done wewewew");

        //no need to handle it manually now.
        //var orderService = new OrderService(new WaffarhaPaymentService());
        //orderService.placeOrder();
    }

}
