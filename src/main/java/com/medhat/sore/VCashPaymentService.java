package com.medhat.sore;

public class VCashPaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("VCash Payment Service");
        System.out.println("Amount: " + amount);

    }
}
