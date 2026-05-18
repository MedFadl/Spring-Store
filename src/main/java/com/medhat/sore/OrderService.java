package com.medhat.sore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


// Service is the same as component, but it is used for business logic
@Service
public class OrderService {
    private PaymentService paymentService;

    public OrderService() {
    }


    @Autowired //This makes it a default for spring to inject instead of using default constructor. (Only used in multiple constructors).
    public OrderService(@Qualifier("VCash") PaymentService paymentService) {
        this.paymentService = paymentService;
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
