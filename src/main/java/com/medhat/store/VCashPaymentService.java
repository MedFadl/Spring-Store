package com.medhat.store;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

//@Service("VCash")
public class VCashPaymentService implements PaymentService {
    @Value("${vcash.apiUrl}")
    private String apiUrl;

    @Value("${vcash.enabled}")
    private boolean isEnabled;

    @Value("${vcash.timeout:3000}")
    private int timeout;

    @Value("${vcash.supportedCurrencies}")
    private List<String> supportedCurrencies;

    @Override
    public void processPayment(double amount) {
        System.out.println("VCash Payment Service");
        if (!isEnabled) {
            System.out.println("VCash payment service is disabled");
            return;
        }
        System.out.println("API URL: " + apiUrl);
        System.out.println("Enabled: " + isEnabled);
        System.out.println("Timeout: " + timeout);
        System.out.println("Supported Currencies: " + supportedCurrencies);
        System.out.println("Amount: " + amount);

    }
}
