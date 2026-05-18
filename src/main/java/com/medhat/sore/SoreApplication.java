package com.medhat.sore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SoreApplication {

    public static void main(String[] args) {
        //We are going to use IOC (inversion of control) to make spring handle objects
        //Bean = Objects that are managed by spring

        ApplicationContext context = SpringApplication.run(SoreApplication.class, args);
        var orderservice = context.getBean(OrderService.class);
        orderservice.placeOrder();

        //no need to handle it manually now.
        //var orderService = new OrderService(new WaffarhaPaymentService());
        //orderService.placeOrder();
    }

}
