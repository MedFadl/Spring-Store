package com.medhat.sore;


import org.springframework.stereotype.Service;

@Service("VCash")
public class VCashPaymentService implements PaymentService {

    @Override
    public void processPayment(double amount) {
        System.out.println("VCash Payment Service");
        System.out.println("Amount: " + amount);

    }
}
