package com.medhat.sore;

import org.springframework.stereotype.Service;

@Service
public class WaffarhaPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Waffarha Payment Service");
        System.out.println("Amount: " + amount);
    }
}
