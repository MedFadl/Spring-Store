package com.medhat.store;

import com.medhat.store.models.Profile;
import com.medhat.store.transactions.ProductService;
import com.medhat.store.transactions.ProfileService;
import com.medhat.store.transactions.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        //context.getBean(UserService.class).showEntityState();
        //context.getBean(UserService.class).showAddress();
        //context.getBean(UserService.class).deleteAddress();
        //context.getBean(ProductService.class).createProduct();
        //context.getBean(ProductService.class).productToWishlist();
        //context.getBean(UserService.class).fetchUserByAddress();
        //context.getBean(UserService.class).showEntityState();
        //context.getBean(ProfileService.class).addProfileToUser();
        context.getBean(ProfileService.class).fetchProfile();
        context.getBean(ProductService.class).fetchProductByExample();
    }

}
