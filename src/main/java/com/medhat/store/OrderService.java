package com.medhat.store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


// Service is the same as component, but it is used for business logic
//@Service
public class OrderService {
    private PaymentService paymentService;

    public OrderService() {
    }

    //This makes it a default for spring to inject instead of using default constructor. (Only used in multiple constructors).
    //@Autowired
    //@Qualifier("Waffarha")
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderService Created");
    }
    @PostConstruct
    public void init(){
        System.out.println("OrderService Initialized");
    }

    @PreDestroy // but we need to close context first we can use that with CONFIGURABLE APPLICATION CONTEXT!! AND THEN .CLOSE IT!!
    public void cleanup(){
        System.out.println("Cleaning connections / file handles and so on");
    }


    public void placeOrder() {
        paymentService.processPayment(100);
    }

    //we can use setter injection to set the payment service instead of constructor injection.
    //If it is an optional dependency, we can use setter injection. But! if it is a mandatory dependency, we should use constructor injection!!.
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

}
