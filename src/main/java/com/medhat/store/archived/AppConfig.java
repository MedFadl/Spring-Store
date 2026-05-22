package com.medhat.store.archived;


import com.medhat.store.archived.notification.EmailNotificationService;
import com.medhat.store.archived.notification.NotificationService;
import com.medhat.store.archived.user.InMemoryUserRepository;
import com.medhat.store.archived.user.UserRepository;
import com.medhat.store.archived.user.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
    @Scope("prototype")
    public OrderService orderService(){
        if(defaultPayment.equalsIgnoreCase("VCash")){ return new OrderService(vCash());}
        return new OrderService(waffarha());
    }


    @Bean
    public NotificationService notificationService(){
        return new EmailNotificationService();
    }

    @Bean
    public UserRepository userRepository(){
        return new InMemoryUserRepository();
    }


    @Bean
    public UserService userService(){
        return new UserService(userRepository(), notificationService());
    }

}
