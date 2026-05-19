package com.medhat.store;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${payment.default}")
    private String defaultPayment;


    //names of beans should be same as the type of the bean
    @Bean
    public PaymentService waffarha(){
        return new WaffarhaPaymentService();
    }

    @Bean
    public PaymentService vCash(){
        return new VCashPaymentService();
    }

    @Bean
    public OrderService orderService(){
        if(defaultPayment.equalsIgnoreCase("VCash")){ return new OrderService(vCash());}
        return new OrderService(waffarha());
    }

}
