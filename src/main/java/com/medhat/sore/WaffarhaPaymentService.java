package com.medhat.sore;

public class WaffarhaPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount) {
        System.out.println("Waffarha Payment Service");
        System.out.println("Amount: " + amount);
    }
}
