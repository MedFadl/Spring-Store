package com.medhat.store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("Waffarha")
@Primary
public class WaffarhaPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Waffarha Payment Service");
        System.out.println("Amount: " + amount);
    }
}
