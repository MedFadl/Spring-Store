package com.medhat.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("Waffarha")
//@Primary
public class WaffarhaPaymentService implements PaymentService {
    @Value("${waffarha.apiUrl}")
    private String apiUrl;

    @Value("${waffarha.enabled}")
    private boolean isEnabled;

    @Value("${waffarha.timeout:3000}")
    private int timeout;

    @Value("${waffarha.supportedCurrencies}")
    private List<String> supportedCurrencies;

    @Override
    public void processPayment(double amount) {
        System.out.println("waffarha Payment Service");
        if (!isEnabled) {
            System.out.println("waffarha payment service is disabled");
            return;
        }
        System.out.println("API URL: " + apiUrl);
        System.out.println("Enabled: " + isEnabled);
        System.out.println("Timeout: " + timeout);
        System.out.println("Supported Currencies: " + supportedCurrencies);
        System.out.println("Amount: " + amount);
    }
}
